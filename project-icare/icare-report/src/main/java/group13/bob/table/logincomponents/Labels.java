package group13.bob.table.logincomponents;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Labels {
	public JLabel usernameLabel(JPanel container){
	    JLabel usernameLabel=new JLabel("USERNAME");
	    usernameLabel.setBounds(75,300,100,30);
	    container.add(usernameLabel);
	    return usernameLabel;
	}
	
	public JLabel passwordLabel(JPanel container){
	    JLabel passwordLabel=new JLabel("PASSWORD");
        passwordLabel.setBounds(75,350,100,30);
	    container.add(passwordLabel);
	    return passwordLabel;
	}
	
	public JTextField usernameLabeTextfield(JPanel container){
	    JTextField usernameTextField=new JTextField();
	    usernameTextField.setBounds(200,300,100,30);
	    container.add(usernameTextField);
	    return usernameTextField;

	}
	
	public JTextField passwordLabelTextfield(JPanel container){
	    JTextField passwordTextField=new JTextField();  
        passwordTextField.setBounds(200,350,100,30);
	    container.add(passwordTextField);
	    return passwordTextField;
	}
	
	public void loginpictureLabel(JPanel panel){
		ImageIcon image = new ImageIcon("./src/main/java/group13/bob/table/logincomponents/logo.jpg");
		JLabel labelpic = new JLabel("", image, JLabel.CENTER);
		labelpic.setBounds(35,0,300,300);
		panel.add(labelpic);
	}
	
}
