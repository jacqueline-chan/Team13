package group13.adam.formmodifier;

import group13.cscc01.forms.*;
import group13.adam.files.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FormModifierPopUp {
  private JFrame modifierFrame;
  private ArrayList<Boolean> includedInTemplate;
  private boolean fieldsSelected;
  private String[] columns;
  private static final ArrayList<JButton> buttons = new ArrayList<JButton>();
  // A counter that keeps track of the amount of fields selected.
  private static int templateColumnNum;

  public FormModifierPopUp() {
    this.columns = (new InfoForm()).getInfoArray();
    includedInTemplate = new ArrayList<Boolean>();
    templateColumnNum = 0;
    fieldsSelected = false;
    modifierFrame = new JFrame("Create new Template");
    modifierFrame.setPreferredSize(new Dimension(500, 500));
    modifierFrame.pack();
    modifierFrame.setLocationRelativeTo(null);
    modifierFrame.setVisible(true);

    JPanel combinePanel = new JPanel(new GridLayout(columns.length, 1));
    // Create an array of buttons that switch the color upon click.
    choiceButtons(combinePanel, buttons);
    JPanel submitPanel = new JPanel(new GridLayout(0, 1));
    JScrollPane scrollPane = new JScrollPane(combinePanel);
    scrollPane
        .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    modifierFrame.add(scrollPane, BorderLayout.CENTER);

    // A check box that selects all the fields.
    checkBox(submitPanel, buttons);

    // Add the button for submit.
    submitButton(submitPanel);

    addFieldButton(submitPanel);
    modifierFrame.add(submitPanel, BorderLayout.PAGE_END);
  }

  private void choiceButtons(JPanel combinePanel,
      final ArrayList<JButton> buttons) {
    for (int i = 0; i < columns.length; i++) {
      final int index = i;
      includedInTemplate.add(false);
      buttons.add(new JButton(columns[i]));
      buttons.get(i).setBackground(Color.RED);
      buttons.get(i).setPreferredSize(new Dimension(40, 40));
      buttons.get(i).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          switchButton(buttons.get(index), index, Color.GREEN);
        }
      });
      combinePanel.add(buttons.get(i));
    }
  }

  private void submitButton(JPanel submitPanel) {
    JButton submitButton = new JButton("Submit the template");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (fieldsSelected) {
          FileManager.saveFile(columns);
        } else {
          String[] fields = new String[templateColumnNum];
          int index = 0;
          for (int i = 0; i < columns.length; i++) {
            if (includedInTemplate.get(i)) {
              fields[index] = columns[i];
              index++;
            }
          }
          FileManager.saveFile(fields);
        }
        modifierFrame.dispose();
      }
    });
    submitPanel.add(submitButton);
  }

  private void checkBox(JPanel submitPanel, final ArrayList<JButton> buttons) {
    JCheckBox selectAll = new JCheckBox("Select all fields");
    selectAll.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < columns.length; i++) {
          if (!((fieldsSelected) ^ (includedInTemplate.get(i)))) {
            switchButton(buttons.get(i), i, Color.GREEN);
          }
        }
        fieldsSelected = !(fieldsSelected);
      }
    });
    submitPanel.add(selectAll);
  }

  private void addFieldButton(JPanel submitPanel) {
    JButton addFieldButton = new JButton("Add a new field to form");
    addFieldButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        nameFieldPopUp();
      }
    });
    submitPanel.add(addFieldButton);
  }

  public void newFieldButton(String regex, JPanel buttonPanel) {
    final JButton newButton = new JButton();
    newButton.setBackground(Color.YELLOW);
    newButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        switchButton(newButton, includedInTemplate.size(), Color.YELLOW);
      }
    });
    buttonPanel.add(newButton);
    buttonPanel.repaint();
  }

  private void switchButton(JButton button, int index, Color color) {
    includedInTemplate.set(index, !(includedInTemplate.get(index)));
    if (includedInTemplate.get(index)) {
      button.setBackground(color);
      templateColumnNum++;
    } else {
      button.setBackground(Color.RED);
      templateColumnNum--;
    }
  }

  public void nameFieldPopUp() {
    final JFrame nameFrame = new JFrame("Type in the name of the field");
    nameFrame.setPreferredSize(new Dimension(400, 200));
    nameFrame.pack();
    nameFrame.setLocationRelativeTo(null);
    nameFrame.setVisible(true);

    final JTextField fileName = new JTextField();
    fileName.setColumns(5);
    fileName.setBorder(BorderFactory.createLineBorder(Color.black));
    nameFrame.add(fileName, BorderLayout.CENTER);
    JPanel savePanel = new JPanel(new GridLayout(0, 1));
    JButton saveButton = new JButton("Save name");
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        nameFrame.dispose();
        chooseRegex(fileName.getText());
      }
    });
    savePanel.add(saveButton);
    nameFrame.add(savePanel, BorderLayout.PAGE_END);
  }
  
  private void chooseRegex(String fieldName) {
    final HashMap<String, String> regexMap = new HashMap<String, String>();
    regexMap.put("A date","(19|20)[0-9]{2}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))");
    regexMap.put("A number", "[0-9]+");
    regexMap.put("A word", "[(A-Z)|(a-z)]+");
    regexMap.put("Multiple words", "[(A-Z)|(a-z)| ]+");
    regexMap.put("Yes or No", "(Yes)|(No)");
    regexMap.put("Other", ".*");
    
    final JFrame regexFrame = new JFrame("Choose the option for field");
    regexFrame.setPreferredSize(new Dimension(400, 200));
    regexFrame.pack();
    regexFrame.setLocationRelativeTo(null);
    regexFrame.setVisible(true);
    JLabel label = new JLabel("Choose the type of data the field will contain");
    JPanel labelPanel = new JPanel();
    labelPanel.add(label);
    regexFrame.add(labelPanel, BorderLayout.PAGE_START);

    final JRadioButton[] choices = new JRadioButton[6];
    choices[0] = new JRadioButton("A date");
    choices[1] = new JRadioButton("A number");
    choices[2] = new JRadioButton("A word");
    choices[3] = new JRadioButton("Multiple words");
    choices[4] = new JRadioButton("Yes or No");
    choices[5] = new JRadioButton("Other");
    final JPanel buttonPanel = new JPanel();
    ButtonGroup group = new ButtonGroup();
    for(int i = 0; i < choices.length; i++) {
      final int index = i;
      group.add(choices[i]);
      buttonPanel.add(choices[i]);
      choices[i].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          regexFrame.dispose();
          newFieldButton(regexMap.get(choices[index].getText()), buttonPanel);
      }
    });
    }
    regexFrame.add(buttonPanel, BorderLayout.CENTER);
  }

}

