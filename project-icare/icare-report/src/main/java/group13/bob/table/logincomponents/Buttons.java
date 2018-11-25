
package group13.bob.table.logincomponents;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons {
	
	public JButton createLoginButton(JPanel container){
	    JButton loginButton=new JButton("LOGIN");
	    loginButton.setBounds(75,450,100,30);
	    container.add(loginButton);
	    return loginButton;

	}
	
	public JButton createCancelButton(JPanel container){
	    JButton cancelButton=new JButton("CANCEL");
	    cancelButton.setBounds(200,450,100,30);
	    container.add(cancelButton);
	    return cancelButton;

	}
	
	public JButton createSignUpButton(JPanel container){
	    JButton signUpButton=new JButton("SIGN UP");
	    signUpButton.setBounds(200,490,100,30);
	    container.add(signUpButton);
	    return signUpButton;

	}
	
	public JButton createSubmitButton(JPanel container){
	    JButton submitButton=new JButton("SUBMIT");
	    submitButton.setBounds(75,490,100,30);
	    container.add(submitButton);
	    return submitButton;

	}
	
	public JButton createBackButton(JPanel container){
	    JButton backButton=new JButton("CANCEL");
	    backButton.setBounds(200,490,100,30);
	    container.add(backButton);
	    return backButton;

	}

}