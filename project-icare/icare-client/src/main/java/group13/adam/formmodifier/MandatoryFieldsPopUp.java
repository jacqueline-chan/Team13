package group13.adam.formmodifier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import group13.adam.files.FileManager;
import group13.adam.gui.ApplicationForm;
import group13.cscc01.forms.InfoForm;

public class MandatoryFieldsPopUp {
  private JFrame mandFrame;
  private ArrayList<Boolean> isMandatory;
  private boolean fieldsSelected;
  private String[] columns;
  private final HashMap<String, String> hashFields;
  private final HashMap<String, String> mandHashFields;
  private final HashMap<String, String> optHashFields;
  private JPanel combinePanel;
  private static final ArrayList<JButton> buttons = new ArrayList<JButton>();
  private ApplicationForm form;
  // A counter that keeps track of the amount of fields selected.
  private static int templateColumnNum;
  

  public MandatoryFieldsPopUp(HashMap<String, String> map, String[] fields, ApplicationForm form) {
    this.form = form;
    this.columns = fields;
    this.hashFields = map;
    this.mandHashFields = new HashMap<String, String>();
    this.optHashFields = new HashMap<String, String>();
    this.combinePanel = new JPanel(new GridLayout(columns.length, 1));
    isMandatory = new ArrayList<Boolean>();
    templateColumnNum = 0;
    fieldsSelected = false;
    
    mandFrame = new JFrame("Choose the mandatory fields");
    mandFrame.setPreferredSize(new Dimension(500, 500));
    mandFrame.pack();
    mandFrame.setLocationRelativeTo(null);
    mandFrame.setVisible(true);
    // Create an array of buttons that switch the color upon click.
    choiceButtons(combinePanel, buttons);
    JPanel submitPanel = new JPanel(new GridLayout(0, 1));
    JScrollPane scrollPane = new JScrollPane(combinePanel);
    scrollPane
        .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    mandFrame.add(scrollPane, BorderLayout.CENTER);
    JLabel label = new JLabel("Choose the mandatory fields for the form");
    JPanel labelPanel = new JPanel();
    labelPanel.add(label);
    mandFrame.add(labelPanel, BorderLayout.PAGE_START);
    
    // A check box that selects all the fields.
    checkBox(submitPanel, buttons);

    // Add the button for submit.
    submitButton(submitPanel);

    mandFrame.add(submitPanel, BorderLayout.PAGE_END);  
  }
  private void switchButton(JButton button, int index) {
    isMandatory.set(index, !(isMandatory.get(index)));
    if (isMandatory.get(index)) {
      button.setBackground(Color.GREEN);
      templateColumnNum++;
    } else {
      button.setBackground(Color.RED);
      templateColumnNum--;
    }
  }
  
  private void checkBox(JPanel submitPanel, final ArrayList<JButton> buttons) {
    JCheckBox selectAll = new JCheckBox("Select all fields");
    selectAll.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < columns.length; i++) {
          if (!((fieldsSelected) ^ (isMandatory.get(i)))) {
            switchButton(buttons.get(i), i);
          }
        }
        fieldsSelected = !(fieldsSelected);
      }
    });
    submitPanel.add(selectAll);
  }
  private void submitButton(JPanel submitPanel) {
    JButton submitButton = new JButton("Submit the new form");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Set This Form Right Now?","Note",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
          form.deleteFrame();
          ApplicationForm.launchGui(mandHashFields, optHashFields);// Saving code here
        }
        mandFrame.dispose();
        if (fieldsSelected) {
          FileManager.saveFile(hashFields, new HashMap<String, String>());
        } else {
          String[] mandFields = new String[templateColumnNum];
          String[] optFields = new String[columns.length-templateColumnNum];
          for (int i = 0; i < columns.length; i++) {
            if (isMandatory.get(i)) {
              mandHashFields.put(columns[i], hashFields.get(columns[i]));
            }
            else {
              optHashFields.put(columns[i], hashFields.get(columns[i]));
            }
          }
          FileManager.saveFile(mandHashFields, optHashFields);
        }
      }
    });
    submitPanel.add(submitButton);
  }
  private void choiceButtons(JPanel combinePanel,
      final ArrayList<JButton> buttons) {
    for (int i = 0; i < columns.length; i++) {
      final int index = i;
      isMandatory.add(false);
      buttons.add(new JButton(columns[i]));
      buttons.get(i).setBackground(Color.RED);
      buttons.get(i).setPreferredSize(new Dimension(40, 40));
      buttons.get(i).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          switchButton(buttons.get(index), index);
        }
      });
      combinePanel.add(buttons.get(i));
    }
  }

}
