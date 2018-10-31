package group13.adam.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.text.*;

import group13.adam.db.InsertFormDB;
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

  String[] fieldNames = new String[] {"Unique Identifier",
      "Date of Birth (YYYY-MM-DD)",
      "Postal Code where the service was received",
      "Start Date of Service (YYYY-MM-DD)", "Language of Service",
      "Official Language of Preference",
      "Type of Institution/Organization Where Client Received Services",
      "Referred By", "Services Received", "Total Length of Orientation",
      "Total Length of Orientation: Hours",
      "Total Length of Orientation: Minutes", "Number of Clients in Group",
      "Directed at a specific Target Group ",
      "Target Group: Children (0-14 yrs)", "Target Group: Youth (15-24 yrs",
      "Target Group: Seniors", "Target Group: Gender-specific",
      "Target Group: Refugees",
      "Target Group: Ethnic/cultural/linguistic group",
      "Target Group: Deaf or Hard of Hearing",
      "Target Group: Blind or Partially Sighted",
      "Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)",
      "Target Group: Families/Parents",
      "Target Group: Clients with other impairments (physical, mental)",
      "Target Group: Clients with international training in a regulated profession",
      "Target Group: Clients with international training in a regulated trade",
      "Target Group: Official Language minorities", "Overview of Canada",
      "Overview of Canada Referrals", "Sources of Information",
      "Sources of Information Referrals", "Rights and Freedoms",
      "Rights and Freedoms Referrals", "Canadian Law and Justice",
      "Important Documents", "Important Documents Referrals",
      "Improving English or French", "Improving English or French Referrals",
      "Employment and Income", "Employment and Income Referrals", "Education",
      "Education Referrals", "Housing", "Housing Referrals", "Health",
      "Health Referrals", "Money and Finances", "Money and Finances Referrals",
      "Transportation", "Transportation Referrals", "Communications and Media",
      "Communications and Media Referrals", "Community Engagement",
      "Community Engagement Referrals", "Becoming a Canadian Citizen",
      "Becoming a Canadian Citizen Referrals", "Interpersonal Conflict",
      "Interpersonal Conflict Referrals",
      "Was Essential Skills and Aptitude Training Received as Part of this Service?",
      "Computer skills", "Document Use",
      "Interpersonal Skills and Workplace Culture", "Leadership Training",
      "Numeracy",
      "Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?",
      "Life Skills",
      "Rights and Responsibilities of Citizenship (based on discover Canada)",
      "Support Services Received", "Care for Newcomer Children", "Child 1: Age",
      "Child 1: Type of Care", "Child 2: Age", "Child 2: Type of Care",
      "Child 3: Age", "Child 3: Type of Care", "Child 4: Age",
      "Child 4: Type of Care", "Child 5: Age", "Child 5: Type of Care",
      "Transportation 2", "Provisions for Disabilities", "Translation",
      "Between", "And", "Interpretation", "Between 1", "And 2",
      "Crisis Counselling", "End Date of Service (YYYY-MM-DD)",
      "Reason for update"};



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

    System.out.println("The number of fields:");
    System.out.println(fieldNames.length);

    for (int i = 0; i < fieldNames.length; i++) {
      JLabel newLabel = new JLabel();
      JFormattedTextField newField = new JFormattedTextField();

      labels[i] = newLabel;
      fields[i] = newField;
      labels[i].setText(fieldNames[i]);
      fields[i].setColumns(10);
      // fields[i].setValue("");
      labels[i].setLabelFor(fields[i]);
      labelPane.add(labels[i]);
      fieldPane.add(fields[i]);

    }

    // create error message and its panel

    JLabel errorMessageLabel = new JLabel();
    errorMessageLabel.setForeground(Color.red);
    errorMessageLabel.setText(
        "There was an error with your submission. Please review the highlighted fields.");
    errorMessagePanel.add(errorMessageLabel);
    errorMessagePanel.setVisible(false);

    // create buttons
    // select button
    JButton selectButton = new JButton("Select File...");
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    selectFiles.add(selectButton);
    // submit button
    JButton submitButton = new JButton("Submit");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        submitForm();
      }
    });

    submitPane.add(submitButton); // add the button to the submit pane

    // border colour

    javax.swing.border.Border blackline;
    blackline = BorderFactory.createLineBorder(Color.green);


    combinePanel.setBorder(blackline);
    labelPane.setBorder(blackline);
    fieldPane.setBorder(blackline);
    combinePanel.add(labelPane);
    combinePanel.add(fieldPane);

    // JScrollPane scrollPane = new JScrollPane(combinePanel);

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
    checkformat();
    System.out.println("The Button was pressed");
    for (int i = 0; i < fieldNames.length; i++) {
      record.updateInfoMap(labels[i].getText(), fields[i].getText());
    }
	submittodb();

    //System.out.println(labels[1].getText() + ":" + fields[1].getText());
  }

  private void checkformat() {
	ErrorPrevention error = new ErrorPrevention();
    JFormattedTextField invalidField = error.CheckIfFieldsAreValid(fieldNames, fields); // returns a
                                                                // field that
                                                                // are not valid
    // if true, display a single message
    if (invalidField != null) { // based on whatever Alex will return
      System.out.println("Something's wrong "+ invalidField.getText());
      errorMessagePanel.setVisible(true);
      //highlightField(invalidField); // highlight every field
      //goToField(invalidField); // go to the first field thats invalid
    } else {
      // if false,
      errorMessagePanel.setVisible(false);
      submittodb();
      
    }


  }

  // not a complete implementation
  private void goToField(JFormattedTextField invalidField) {
    // test button
    labels[31].scrollRectToVisible(labels[31].getBounds());
    fields[31].requestFocusInWindow(); // moves the cursor to the field
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
		  fieldsString[i] = value ;
	  }
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
