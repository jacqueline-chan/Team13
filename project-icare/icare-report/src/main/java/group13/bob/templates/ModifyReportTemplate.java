package group13.bob.templates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ModifyReportTemplate extends JFrame{
	JPanel panel;
    
	public ModifyReportTemplate(){
		panel = new JPanel();
		
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	    setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    setUndecorated(true);

	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setTitle("Modify");
	    
	    JPanel middle = new JPanel();
	    middle.setLayout(new BoxLayout(middle,BoxLayout.Y_AXIS));	    
	    middle.add (new JLabel("<html><body><p style=\"padding:10; font-size:20\">These are the available template files:</p><p style=\"padding:10; </body></html>"));
	    ArrayList<String> templatelist = gettemplates();
	    
	    for (int i=0;i<templatelist.size(); i++){
	    JLabel tem = new JLabel(templatelist.get(i));
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
	    			if (templatelist.contains(field.getText())){
	    			ModifyExistingReportAttributes frame = new ModifyExistingReportAttributes(field.getText());
	    	        frame.setVisible(true);
	    	        dispose();
	    			}
	    		} catch (Exception error) {
	    			error.printStackTrace();
	    		}
	        }
	      });
		
	    middle.add (new JLabel("<html><body><p style=\"padding:10; font-size:20\">Enter the name of the template that you want to modify:</p><p style=\"padding:10; </body></html>"));
		
		middle.add(field);
		middle.add(submitButton);
		middle.add(cancelButton);

	    panel.add(middle);
	    
	    JScrollPane scrollPane = new JScrollPane(panel,   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		setContentPane(scrollPane);
	}
	
	
	private ArrayList<String> gettemplates(){
		//Process p = new ProcessBuilder("ls -p ../../../../../../ | grep -v / | grep -v 'pom.xml'").start();
		ArrayList<String> result = new ArrayList<String>();
		try {
		    String[] cmd = {
		    		"/bin/sh",
		    		"-c",
		    		"ls -p | grep -v / | grep -v 'pom.xml' "
		    		};

		    Process p = Runtime.getRuntime().exec(cmd); //Runtime r = Runtime.getRuntime(); Process p = r.exec(cmd);
		    BufferedReader in =
		        new BufferedReader(new InputStreamReader(p.getInputStream()));
		    String inputLine;
		    while ((inputLine = in.readLine()) != null) {
		        result.add(inputLine);
		    }
		    in.close();

		} catch (IOException e) {
		    System.out.println(e);
		}
		
		return result;
		}

	
}
