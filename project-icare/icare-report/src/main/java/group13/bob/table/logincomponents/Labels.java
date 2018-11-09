package group13.bob.table.logincomponents;

import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Labels {
	public JLabel usernameLabel(Container container){
	    JLabel usernameLabel=new JLabel("USERNAME");
	    usernameLabel.setBounds(75,300,100,30);
	    container.add(usernameLabel);
	    return usernameLabel;
	}
	
	public JLabel passwordLabel(Container container){
	    JLabel passwordLabel=new JLabel("PASSWORD");
        passwordLabel.setBounds(75,350,100,30);
	    container.add(passwordLabel);
	    return passwordLabel;
	}
	
	public JTextField usernameLabeTextfield(Container container){
	    JTextField usernameTextField=new JTextField();
	    usernameTextField.setBounds(200,300,100,30);
	    container.add(usernameTextField);
	    return usernameTextField;

	}
	
	public JTextField passwordLabelTextfield(Container container){
	    JTextField passwordTextField=new JTextField();  
        passwordTextField.setBounds(200,350,100,30);
	    container.add(passwordTextField);
	    return passwordTextField;
	}
	
}
