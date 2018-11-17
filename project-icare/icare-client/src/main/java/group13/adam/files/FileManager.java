package group13.adam.files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileManager {
  private static String[] fields;
  
  private static String[] getFromFile(String name) throws IOException {
    System.out.println(name);
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
      return new String[] {"Something is wrong"};
    }
  }
  
  private static void createFile(String name, HashMap<String, String> mandFields, 
      HashMap<String, String> optFields) throws IOException {
    BufferedWriter temp = new BufferedWriter(new FileWriter(name));
    temp.write(mandFields.size() + "\n");
    for(Map.Entry<String, String> entry : mandFields.entrySet()) {
      temp.write(entry.getKey() + "\n");
      temp.write(entry.getValue() + "\n");
    }
    temp.write(optFields.size() + "\n");
    for(Map.Entry<String, String> entry : optFields.entrySet()) {
      temp.write(entry.getKey() + "\n");
      temp.write(entry.getValue() + "\n");
    }
    temp.flush();
    temp.close();
  }
  

  //Methods for the pop-up windows
  
  public static void saveFile(final HashMap<String, String> mandFields,
      final HashMap<String, String> optFields) {
    final FilePopUp genPopUp = new FilePopUp();
    final JFrame genFrame = genPopUp.getJFrame();
    JPanel savePanel = new JPanel(new GridLayout(0, 1));
    JButton saveButton = new JButton("Confirm name");
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          createFile(genPopUp.getFileName(), mandFields, optFields);
        } catch (IOException e1) {
          System.out.println("Something is wrong");
        }
        genFrame.dispose();
      }
    });
    savePanel.add(saveButton);
    genFrame.add(savePanel, BorderLayout.PAGE_END);
  }
  
  
  public static void getFile() {
    final FilePopUp genPopUp = new FilePopUp();
    final JFrame genFrame = genPopUp.getJFrame();
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
  }

}
