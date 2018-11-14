package group13.bob.files;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FilePopUp {
  private JFrame nameFrame;
  private JTextField fileName;
  public FilePopUp() {
    nameFrame = new JFrame("Type in the name of the file");
    nameFrame.setPreferredSize(new Dimension(400, 200));
    nameFrame.pack();
    nameFrame.setLocationRelativeTo(null);
    nameFrame.setVisible(true);
    
    fileName = new JTextField();
    fileName.setColumns(5);
    fileName.setBorder(BorderFactory.createLineBorder(Color.black));
    nameFrame.add(fileName);
  }
  public JFrame getJFrame() {
    return this.nameFrame;
  }
  public String getFileName() {
    return fileName.getText();
  }
}
