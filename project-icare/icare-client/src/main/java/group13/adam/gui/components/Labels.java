package group13.adam.gui.components;

import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Labels {
	
	
	public JLabel[] initializeJLabels(String[] fieldNames, JPanel labelPane, JFormattedTextField[] fields, JPanel combinePanel){
		JLabel[] labels = new JLabel[100];
		for (int i = 0; i < fieldNames.length; i++) {
			  JLabel newLabel = new JLabel();
			  labels[i] = newLabel;
			  labels[i].setText(fieldNames[i]);
			  labels[i].setLabelFor(fields[i]);
			  labelPane.add(labels[i]);

		}
		combinePanel.add(labelPane);
		return labels;	
	}
	
	public JFormattedTextField[] initializeJFormattedTextField(String[] fieldNames, JPanel fieldPane , JPanel combinePanel){
		JFormattedTextField[] fields = new JFormattedTextField[100];
	    for (int i = 0; i < fieldNames.length; i++) {
	        JFormattedTextField newField = new JFormattedTextField();
	    	fields[i] = newField;
	        fields[i].setColumns(10);
	        fieldPane.add(fields[i]);

	    }
	    
        combinePanel.add(fieldPane);
	    return fields;
		
	}

	
	
	
	
	
	
	public JLabel createErrorLabel(JPanel errorMessagePanel){
	JLabel errorMessageLabel = new JLabel();
    errorMessageLabel.setForeground(Color.red);
    errorMessageLabel.setText(
        "There was an error with your submission. Please review the highlighted fields.");
    errorMessagePanel.add(errorMessageLabel);
    errorMessagePanel.setVisible(false);
	return errorMessageLabel;
    
	}

}
