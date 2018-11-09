package group13.bob.table;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import group13.bob.table.logincomponents.Buttons;
import group13.bob.table.logincomponents.Labels;

public class Login extends JFrame{
	
    Container container=getContentPane();
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField logintextfield;
    JTextField passwordtextfield;
    String password;
    String username;
    
	public Login(){
		container.setLayout(null);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
	    setBounds(500, 100, 370, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("LoginPage");
		
		Buttons button = new Buttons();
		Labels labels = new Labels();
		
		labels.usernameLabel(container);
		labels.passwordLabel(container);
		logintextfield = labels.usernameLabeTextfield(container);
		passwordtextfield = labels.passwordLabelTextfield(container);
		
		JButton cancelButton = button.createCancelButton(container);
		cancelButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	logintextfield.setText("");
	        	passwordtextfield.setText("");
	        }
	      });
		JButton loginButton = button.createLoginButton(container);
		loginButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	getCredentials();
	        	verifyCredentials();
	        	lauchTableGui();
	        }
	      });
		
		
	}
	
	protected void getCredentials(){
		username = logintextfield.getText();
		password = passwordtextfield.getText();
	}
	
	protected void verifyCredentials(){
		//if password/username is wrong, display message
		//unsuccessfulDialog
		//else submitDB();
    	submitDB();
	}

	protected void submitDB(){
		//call function to submit to db
		username="";
		password="";
	}
	
	protected void unsuccessfulDialog(){
		JOptionPane.showMessageDialog(container, "login Not Successful");
		
	}
	
	protected void lauchTableGui() {
		try {
			Table frame = new Table();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
