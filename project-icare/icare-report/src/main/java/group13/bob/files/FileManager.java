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
  private static FilePopUp genPopUp = new FilePopUp();
  private static JFrame genFrame = genPopUp.getJFrame();
  private static String[] fields = new String[] {"Ya dun goofed"};
  
  private static String[] getFromFile(String name) throws IOException {
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
  public static void saveFile(String[] fields) {
    
    JPanel savePanel = new JPanel(new GridLayout(0, 1));
    JButton saveButton = new JButton("Confirm name");
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          createFile(genPopUp.getFileName(), fields);
        } catch (IOException e1) {
          System.out.println("Something is wrong");
        }
        genFrame.dispose();
      }
    });
    savePanel.add(saveButton);
    genFrame.add(savePanel, BorderLayout.PAGE_END);
  }
  public static String[] getFile() {
    JPanel savePanel = new JPanel(new GridLayout(0, 1));
    JButton saveButton = new JButton("Confirm name");
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          fields = getFromFile(genPopUp.getFileName());
        } catch (IOException e1) {
          System.out.println("Something is wrong");
        }
        genFrame.dispose();
      }
    });
    savePanel.add(saveButton);
    genFrame.add(savePanel, BorderLayout.PAGE_END);
    return fields;
  }
  private static void createFile(String name, String[] fields) throws IOException {
    BufferedWriter temp = new BufferedWriter(new FileWriter(name));
    temp.write(fields.length + "\n");
    for(int i = 0; i < fields.length; i++) {
      temp.write(fields[i]+"\n");
    }
    temp.flush();
    temp.close();
  }
}
