package group13.bob.files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileManager {
  public static String[] getFromFile(String name) throws IOException {
    try {
      FileReader fr = new FileReader(name);
      BufferedReader br = new BufferedReader(fr);
      int numFields = Integer.parseInt(br.readLine());
      String[] fields = new String[numFields];
      for(int i = 0; i < numFields; i++) {
        fields[i] = br.readLine();
      }
      fr.close();
      br.close();
      return fields;
    } catch (IOException e) {
      return new String[1];
    }
  }
  public static void saveFilePopUp(String[] fields) {
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
          saveToFile(fileName.getText(), fields);
        } catch (IOException e1) {
          System.out.println("Something is wrong");
        }
        nameFrame.dispose();
      }
    });
    savePanel.add(saveButton);
    nameFrame.add(savePanel, BorderLayout.PAGE_END);
  }
  private static void saveToFile(String name, String[] fields) throws IOException {
    BufferedWriter temp = new BufferedWriter(new FileWriter(name));
    temp.write(fields.length + "\n");
    for(int i = 0; i < fields.length; i++) {
      temp.write(fields[i]+"\n");
    }
    temp.flush();
    temp.close();
  }
}
