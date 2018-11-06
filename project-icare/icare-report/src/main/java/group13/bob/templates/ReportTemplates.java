package group13.bob.templates;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
public class ReportTemplates {
  private static String[] columns = FormArray.getColumnNames();
  private static boolean[] includedInTemplate;
  private static JFrame templateFrame;
  private static int templateColumnNum;
  
  public static void CreateTemplatePopUp() {
    includedInTemplate = new boolean[columns.length];
    templateColumnNum = 0;
    templateFrame = new JFrame("Create new Template");
    templateFrame.setPreferredSize(new Dimension(500, 500));
    templateFrame.pack();
    templateFrame.setLocationRelativeTo(null);
    templateFrame.setVisible(true);
    
    JPanel combinePanel = new JPanel(new GridLayout(columns.length, 1));
    JButton[] buttons = new JButton[columns.length];
    for(int i = 0; i < columns.length; i++ ) {
      final int index = i;
      buttons[i] = new JButton(columns[i]);
      buttons[i].setBackground(Color.RED);
      buttons[i].setPreferredSize(new Dimension(10, 100));
      buttons[i].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        switchButton(buttons[index], index);
      }
    });
      combinePanel.add(buttons[i]);
    }
    JScrollPane scrollPane = new JScrollPane(combinePanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    templateFrame.add(scrollPane, BorderLayout.CENTER);
    // Add the button for submit.
    JPanel submitPanel = new JPanel(new GridLayout(0, 1));
    JButton submitButton = new JButton("Submit the template");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        createNamePopUp();
      }
    });
    submitPanel.add(submitButton);
    templateFrame.add(submitPanel, BorderLayout.PAGE_END);
    
  }
  
  private static void switchButton(JButton button, int index) {
    includedInTemplate[index] = !(includedInTemplate[index]);
    if (includedInTemplate[index]) {
      //System.out.println(columns[index]);
      button.setBackground(Color.GREEN);
      //button.repaint();
      //button.setContentAreaFilled(false);
      templateColumnNum++;
    } else {
      button.setBackground(Color.RED);
      templateColumnNum--;
    }
  }
  private static void saveTemplate(String name) throws IOException {
    BufferedWriter temp = new BufferedWriter(new FileWriter(name));
    String[] templateNames = new String[templateColumnNum];
    int index = 0;
    System.out.println("Name: "+name);
    for (int i = 0; i < columns.length; i++) {
      if (includedInTemplate[i]) {
        templateNames[index] = columns[i];
        index++;
      }
    }
    for(int i = 0; i < templateNames.length; i++) {
      
      System.out.println(templateNames[i]);
      temp.write(templateNames[i]+"\n");
    }
    temp.flush();
    temp.close();
    templateFrame.dispose();
  }
  
  
  private static void createNamePopUp() {
    JFrame nameFrame = new JFrame("Type in the name of the file");
    nameFrame.setPreferredSize(new Dimension(400, 200));
    nameFrame.pack();
    nameFrame.setLocationRelativeTo(null);
    nameFrame.setVisible(true);
    
    JTextField fileName = new JTextField();
    fileName.setColumns(5);
    fileName.setBorder(BorderFactory.createLineBorder(Color.black));
    nameFrame.add(fileName);
    //fileName.setColumns(10);
    JPanel savePanel = new JPanel(new GridLayout(0, 1));
    JButton saveButton = new JButton("Save name");
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          saveTemplate(fileName.getText());
        } catch (IOException e1) {
          System.out.println("Something is wrong");
        }
        nameFrame.dispose();
      }
    });
    savePanel.add(saveButton);
    nameFrame.add(savePanel, BorderLayout.PAGE_END);
  }
}
