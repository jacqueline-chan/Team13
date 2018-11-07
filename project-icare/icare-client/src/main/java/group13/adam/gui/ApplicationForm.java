package group13.adam.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.text.*;

import group13.adam.db.InsertFormDB;
import group13.adam.gui.components.Buttons;
import group13.adam.gui.components.Labels;
import group13.adam.gui.components.Strings;
import group13.adam.validation.ErrorPrevention;
import group13.cscc01.forms.InfoForm;
//import javafx.scene.layout.Border;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.text.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationForm extends JPanel {

  InfoForm record = new InfoForm();
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


  public ApplicationForm() {
    super(new BorderLayout());
    
    Strings StringsObject = new Strings();
    Buttons ButtonsObject = new Buttons();
    Labels LabelsObject = new Labels();
   
    fieldNames = StringsObject.headerstring();
    
    fields = LabelsObject.initializeJFormattedTextField(fieldNames, fieldPane, combinePanel);
    labels = LabelsObject.initializeJLabels(fieldNames, labelPane, fields, combinePanel);
    
    // create error message and its panel
    LabelsObject.createErrorLabel(errorMessagePanel);

    // create buttons
    
    // select button, JPanel selectFiles
    ButtonsObject.selectButton(selectFiles);
    
    // submit button
    JButton submitButton = ButtonsObject.submitButton(submitPane);
    
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        submitForm();
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

  public void submitForm() {
    // will need to loop this until everything is satisfied
	//submittodb();
    //checkformat();
    System.out.println("The Submit Button was pressed");
    for (int i = 0; i < fieldNames.length; i++) {
      record.updateInfoMap(labels[i].getText(), fields[i].getText());
     //System.out.println(labels[i].getText() + ":" + fields[i].getText());
     //System.out.println(record.getInfoMap().get(fieldNames[i]));
    }
	submittodb();

  }

  private void checkformat() {
	ErrorPrevention error = new ErrorPrevention();
    int fieldIndex = error.CheckIfFieldsAreValid(fieldNames, fields); // returns a
                                                                // field that
                                                                // are not valid
    // if true, display a single message
    if (fieldIndex > -1) {
      // System.out.println("Something's wrong "+ invalidField.getText());
      errorMessagePanel.setVisible(true);
      //highlightField(invalidField); // highlight every field
      goToField(fieldIndex); // go to the first field thats invalid
    } else {
      // if false,
      errorMessagePanel.setVisible(false);
      submittodb();
      
    }


  }

  // not a complete implementation (Implementation fixed)
  private void goToField(int index) {
    // test button
    labels[index].scrollRectToVisible(labels[index].getBounds());
    fields[index].requestFocusInWindow(); // moves the cursor to the field
  }

  // not a complete implementation
  private void highlightField(JFormattedTextField invalidField) {
    Arrays.asList(fields).indexOf(invalidField);
  }


  /**
   * Create the GUI and show it. For thread safety, this method should be
   * invoked from the event dispatch thread.
   */
  private static void createAndShowGUI() {
    // Create and set up the window.
    JFrame frame = new JFrame("ApplicationForm");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add contents to the window.
    frame.add(new ApplicationForm());

    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }


  public InfoForm returnSubmission() {
    return record;
  }
  
  public String[] getfieldNames(){
	  return fieldNames;
  }
  
  public JFormattedTextField[] getfields(){
	  return fields;
  }
  
  public InfoForm submittodb() {
	  String [] fieldsString = new String [fieldNames.length];
	  for (int i = 0; i < fieldNames.length; i++) {
		  String value = record.getInfoMap().get(fieldNames[i]);
		  System.out.println(fieldNames[i] + ":" + value);
		  fieldsString[i] = value ;
	  }
	  //System.out.println(fieldsString.toString());
	  System.out.println(Arrays.toString(fieldsString));
	  
	  //bug?
	  InsertFormDB insertform = new InsertFormDB();
	  insertform.insert(fieldsString);
	  
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
}
