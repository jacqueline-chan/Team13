package group13.adam.formmodifier;

import group13.cscc01.forms.*;
import group13.adam.validation.*;
import group13.adam.files.*;
import group13.adam.gui.ApplicationForm;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
  private ApplicationForm form;
  private ArrayList<Boolean> includedInTemplate;
  private boolean fieldsSelected;
  private ArrayList<String> columns;
  final private HashMap<String, String> mandFields;
  final private HashMap<String, String> optFields;
  private HashMap<String, String> newFields;
  
  private JPanel combinePanel;
  private final ArrayList<JButton> buttons;
  
  // A counter that keeps track of the amount of fields selected.
  private static int fieldsNum;

  public FormModifierPopUp(ApplicationForm form) {
    buttons = new ArrayList<JButton>();
    this.form = form;
    columns = new ArrayList<String>();
    FormManager fm = form.returnSubmission();
    String[] temp = form.getfieldNames();
    newFields = new HashMap<String, String>();
    mandFields = fm.getMandFields();
    optFields = fm.getOptFields();
    for (int i = 0; i < temp.length; i++) {
      this.columns.add(temp[i]);
    }
    this.combinePanel = new JPanel(/* new GridLayout(columns.length, 1) */);
    BoxLayout bl = new BoxLayout(combinePanel, BoxLayout.Y_AXIS);
    combinePanel.setLayout(bl);
    includedInTemplate = new ArrayList<Boolean>();
    fieldsNum = 0;
    fieldsSelected = false;
    modifierFrame = new JFrame("Modify the existing form");
    modifierFrame.setPreferredSize(new Dimension(500, 500));
    modifierFrame.pack();
    modifierFrame.setLocationRelativeTo(null);
    modifierFrame.setVisible(true);
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
    for (int i = 0; i < columns.size(); i++) {
      final int index = i;
      includedInTemplate.add(false);
      String temp = columns.get(i);
      buttons.add(new JButton(temp));
      System.out.println(temp);
      //System.out.println(buttons.get(i).getText());
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
    final HashMap<String, String> newFormFields = new HashMap<String, String>();
    JButton submitButton = new JButton("Submit the new form");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        modifierFrame.dispose();
          String[] fields = new String[fieldsNum];
          int index = 0;
          for (int i = 0; i < columns.size(); i++) {
            if (includedInTemplate.get(i)) {
              if (mandFields.containsKey(columns.get(i))) {
                newFormFields.put(columns.get(i), mandFields.get(columns.get(i)));
              }
              else if (optFields.containsKey(columns.get(i))) {
                newFormFields.put(columns.get(i), optFields.get(columns.get(i)));
              }
              else if (newFields.containsKey(columns.get(i))) {
                newFormFields.put(columns.get(i), newFields.get(columns.get(i)));
              }
              fields[index] = columns.get(i);
              index++;
            }
          }
          MandatoryFieldsPopUp popUp = new MandatoryFieldsPopUp(newFormFields, fields, form);
        }
    });
    submitPanel.add(submitButton);
  }

  private void checkBox(JPanel submitPanel, final ArrayList<JButton> buttons) {
    JCheckBox selectAll = new JCheckBox("Select all fields");
    selectAll.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < columns.size(); i++) {
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

  public void newFieldButton(String regex, String name) {
    final JButton newButton = new JButton(name);
    newButton.setBackground(Color.YELLOW);
    newButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        final int thisIndex = includedInTemplate.size() - 1;
        switchButton(newButton, thisIndex, Color.YELLOW);
      }
    });
    fieldsNum++;
    columns.add(name);
    buttons.add(newButton);
    newFields.put(name, regex);
    includedInTemplate.add(true);
    combinePanel.add(newButton);
    // modifierFrame.add(combinePanel);
  }

  private void switchButton(JButton button, int index, Color color) {
    includedInTemplate.set(index, !(includedInTemplate.get(index)));
    if (includedInTemplate.get(index)) {
      button.setBackground(color);
      fieldsNum++;
    } else {
      button.setBackground(Color.RED);
      fieldsNum--;
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

  private void chooseRegex(final String fieldName) {
    final HashMap<String, String> regexMap = new HashMap<String, String>();
    regexMap.put("A date",
        "(19|20)[0-9]{2}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))");
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
    for (int i = 0; i < choices.length; i++) {
      final int index = i;
      group.add(choices[i]);
      buttonPanel.add(choices[i]);
      choices[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          regexFrame.dispose();
          newFieldButton(regexMap.get(choices[index].getText()), fieldName);
        }
      });
    }
    regexFrame.add(buttonPanel, BorderLayout.CENTER);
  }

}

