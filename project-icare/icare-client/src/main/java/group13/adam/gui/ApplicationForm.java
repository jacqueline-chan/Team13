package group13.adam.gui;


import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.*;

import group13.adam.db.InsertFormDB;
import group13.adam.draganddrop.DragAndDrop;
import group13.adam.gui.components.Buttons;
import group13.adam.gui.components.Labels;
import group13.adam.gui.components.Strings;
import group13.adam.files.*;
import group13.adam.formmodifier.FormModifierPopUp;
import group13.adam.validation.ErrorPrevention;
import group13.cscc01.forms.FormManager;
//import group13.cscc01.forms.InfoForm;

public class ApplicationForm extends JPanel {

  FormManager record;
  private static JFrame frame;
  JLabel[] labels = new JLabel[100];
  JFormattedTextField[] fields = new JFormattedTextField[100];
  String[] fieldNames = new String[200];
  // Lay out the labels in a panel.
  JPanel labelPane = new JPanel(new GridLayout(0, 1));
  // Layout the text fields in a panel.
  JPanel fieldPane = new JPanel(new GridLayout(0, 1));
  JPanel selectFiles = new JPanel(new GridLayout(0, 1));
  JPanel submitPane = new JPanel(new GridLayout(0, 1));
  JPanel errorMessagePanel = new JPanel();
  // static JButton submitButton = new JButton("Submit");
  JPanel combinePanel = new JPanel(new GridLayout(1, 3));
  JScrollPane scrollPane = new JScrollPane(combinePanel);
  int highlightedField = -1;


  public ApplicationForm() {
    super(new BorderLayout());
    record =  new FormManager("Default_form");
    commonConstructor();
  }
  public ApplicationForm(HashMap<String, String> mand, HashMap<String, String> opt) {
    super(new BorderLayout());
    record = new FormManager(mand, opt);
    commonConstructor();
  }
  private void commonConstructor() {
    //Strings StringsObject = new Strings();
    Buttons ButtonsObject = new Buttons();
    Labels LabelsObject = new Labels();
   
    fieldNames = record.getInfoArray(); //StringsObject.headerstring();
    fields = LabelsObject.initializeJFormattedTextField(fieldNames, fieldPane, combinePanel);
    labels = LabelsObject.initializeJLabels(fieldNames, labelPane, fields, combinePanel);
    
    // create error message and its panel
    LabelsObject.createErrorLabel(errorMessagePanel);
    // select button, JPanel selectFiles
    ButtonsObject.selectButton(selectFiles);

    // submit button
    JButton submitButton = ButtonsObject.submitButton(submitPane);
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        submitForm();
      }
    });
    final ApplicationForm tempForm = this;
    JButton changeFormButton = ButtonsObject.changeFormButton(submitPane);
    changeFormButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        FormModifierPopUp popUp = new FormModifierPopUp(tempForm);
      }
    });
    JButton importFormButton = ButtonsObject.importFormButton(submitPane);
    importFormButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        FileManager.getFile(record);
        tempForm.deleteFrame();
      }
    });    
    // Put the panels in this panel, labels on left,
    // text fields on right.
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    add(errorMessagePanel, BorderLayout.PAGE_START);
    add(scrollPane, BorderLayout.CENTER);
    add(selectFiles, BorderLayout.LINE_END);
    add(submitPane, BorderLayout.PAGE_END);
  }
  private void submitForm() {
    ErrorPrevention error = new ErrorPrevention(record);
    int fieldIndex = error.CheckIfFieldsAreValid(fieldNames, fields);
    // if true, display a single message
    if (fieldIndex > -1) {
      errorMessagePanel.setVisible(true);
      goToField(fieldIndex); // go to the first field thats invalid
    } else {
      errorMessagePanel.setVisible(false);
      storeInfoForm();
      submittodb();
    }

  }

  public void deleteFrame() {
    frame.dispose();
  }
  private void storeInfoForm(){
     for (int i = 0; i < fieldNames.length; i++) {
	 record.updateInfoMap(labels[i].getText(), fields[i].getText());
     }
  }

  private void goToField(int index) {
    labels[index].scrollRectToVisible(labels[index].getBounds());
    fields[index].requestFocusInWindow(); // moves the cursor to the field
    highlightField(index);
  }

  // not a complete implementation
  private void highlightField(int index) {
	unhighlightField();
	labels[index].setForeground(Color.red);
	highlightedField=index;
  }
  
  private void unhighlightField() {
	if (highlightedField != -1){
		  labels[highlightedField].setForeground(Color.black);
	}
  }

  /**
   * Create the GUI and show it. For thread safety, this method should be
   * invoked from the event dispatch thread.
   */
  private static void createAndShowGUI() {
    // Create and set up the window.
    frame = new JFrame("ApplicationForm");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Add contents to the window.
    frame.add(new ApplicationForm());
    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }
  private static void createAndShowGUI(HashMap<String, String> mand, HashMap<String, String> opt) {
    // Create and set up the window.
    frame = new JFrame("ApplicationForm");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Add contents to the window.
    frame.add(new ApplicationForm(mand, opt));
    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public FormManager returnSubmission() {
    return record;
  }
  
  public String[] getfieldNames(){
	  return fieldNames;
  }
  
  public JFormattedTextField[] getfields(){
	  return fields;
  }
  
  public FormManager submittodb() {
	  String [] fieldsString = new String [fieldNames.length];
	  for (int i = 0; i < fieldNames.length; i++) {
		  String value = record.getInfoMap().get(fieldNames[i]);
		  fieldsString[i] = value;
	  }
	  InsertFormDB insertform = new InsertFormDB();
	  try {
		insertform.insert(fieldsString);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  unhighlightField();
	  highlightedField=-1;
	return record;
  }


  public static void launchGui() {
    // Schedule a job for the event dispatch thread:
    // creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        // Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
      }
    });
  }
  public static void launchGui(final HashMap<String, String> mand, final HashMap<String, String> opt) {
    // Schedule a job for the event dispatch thread:
    // creating and showing this application's GUI.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        // Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI(mand, opt);
      }
    });
  }
}
