package group13.adam.gui.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import group13.adam.draganddrop.DragAndDrop;

public class Buttons {
	
	public JButton selectButton(JPanel selectFiles){
		JButton selectButton = new JButton("Select File...");
		selectFiles.add(selectButton);

	    selectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DragAndDrop.ShowDragAndDrop();
			}
	    	
	    });

		return selectButton;
	}
	
	public JButton submitButton(JPanel submitPane){
		JButton submitButton = new JButton("Submit");
		submitPane.add(submitButton);
		return submitButton;
	}

}
