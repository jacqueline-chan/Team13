package group13.adam.gui.components;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons {
	
	
	public JButton selectButton(JPanel selectFiles){
		JButton selectButton = new JButton("Select File...");
		selectFiles.add(selectButton);
		return selectButton;
	}
	
	public JButton submitButton(JPanel submitPane){
		JButton submitButton = new JButton("Submit");
		submitPane.add(submitButton);
		return submitButton;
	}

}
