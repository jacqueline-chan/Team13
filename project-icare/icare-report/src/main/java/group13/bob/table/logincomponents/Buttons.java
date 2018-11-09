package group13.bob.table.logincomponents;

import java.awt.Container;
import javax.swing.JButton;

public class Buttons {
	
	public JButton createLoginButton(Container container){
	    JButton loginButton=new JButton("LOGIN");
	    loginButton.setBounds(75,400,100,30);
	    container.add(loginButton);
	    return loginButton;

	}
	
	public JButton createCancelButton(Container container){
	    JButton cancelButton=new JButton("CANCEL");
	    cancelButton.setBounds(200,400,100,30);
	    container.add(cancelButton);
	    return cancelButton;

	}

}
