package group13.bob.table.logincomponents;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons {
	
	public JButton createLoginButton(JPanel container){
	    JButton loginButton=new JButton("LOGIN");
	    loginButton.setBounds(75,400,100,30);
	    container.add(loginButton);
	    return loginButton;

	}
	
	public JButton createCancelButton(JPanel container){
	    JButton cancelButton=new JButton("CANCEL");
	    cancelButton.setBounds(200,400,100,30);
	    container.add(cancelButton);
	    return cancelButton;

	}
	
	public JButton createSignUpButton(JPanel container){
	    JButton cancelButton=new JButton("SIGN UP");
	    cancelButton.setBounds(200,450,100,30);
	    container.add(cancelButton);
	    return cancelButton;

	}

}
