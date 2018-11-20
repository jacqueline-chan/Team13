package group13.bob.templates;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ModifyExistingReportAttributes extends JFrame{
	public ModifyExistingReportAttributes(String File){
		JPanel panel = new JPanel();
	    setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    setUndecorated(true);

	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setTitle("Modify");
	    
	    JPanel middle = new JPanel();
	    middle.setLayout(new BoxLayout(middle,BoxLayout.Y_AXIS));	    
	    middle.add (new JLabel("<html><body><p style=\"padding:10; font-size:20\">These are the available attribute files:</p><p style=\"padding:10; </body></html>"));
	    ArrayList<String> attributelist = getTemplatesAttributes(File);
	    
	    for (int i=0;i<attributelist.size(); i++){
	    JLabel tem = new JLabel(attributelist.get(i));
	    middle.add(tem);
	    }
	    
	    JButton cancelButton=new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	dispose();
	        }
	      });
		
		JTextField field = new JTextField();

	    JButton submitButton=new JButton("ENTER");
	    submitButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	    		try {
	    			// CALL ALEX'S FUNCTINO TO MODIFY THE FORM
	    		} catch (Exception error) {
	    			error.printStackTrace();
	    		}
	        }
	      });
		
	    middle.add (new JLabel("<html><body><p style=\"padding:10; font-size:20\">Enter the name of the attribute that you want to MODIFY:</p><p style=\"padding:10; </body></html>"));
		
		middle.add(field);
		middle.add(submitButton);
		middle.add(cancelButton);

	    panel.add(middle);
	    
	    JScrollPane scrollPane = new JScrollPane(panel,   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		setContentPane(scrollPane);
	}
	
	public ArrayList<String> getTemplatesAttributes(String File){
		ArrayList<String> listofAttributes = new ArrayList<String>();
		File file = new File(File);
		BufferedReader reader = null;

		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    reader.readLine(); // skip the number in the beginning
		    while ((text = reader.readLine()) != null) {
		    	listofAttributes.add(text);
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
		
		//print out the list
		return listofAttributes;
	}
	
}
