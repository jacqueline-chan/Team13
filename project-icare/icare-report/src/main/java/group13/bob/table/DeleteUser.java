package group13.bob.table;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import group13.bob.sqlite.SqlConnect;
import group13.bob.sqlite.SqlQuery;
import group13.bob.table.logincomponents.Buttons;
import group13.bob.table.logincomponents.Labels;

public class DeleteUser extends JFrame{
	JPanel panel;
    JTextField logintextfield;
    private static final String DBLOGINLOCATION = "../icare-db/login.db";

	public DeleteUser(){
        panel = new JPanel();
        panel.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        setBounds(500, 100, 370, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("DeleteUserPage");
        
        Buttons button = new Buttons();
        Labels labels = new Labels();

        labels.loginpictureLabel(panel);
        labels.usernameLabel(panel);
        logintextfield = labels.usernameLabeTextfield(panel);
        
        JButton createSubmitButton = button.createSubmitButton(panel);
        createSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	deleteLoginUser(logintextfield.getText());
            }
        });

        JButton backButton = button.createBackButton(panel);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logintextfield.setText("");
                dispose();
            }
        });
        
        setContentPane(panel);

	}
	
    public boolean checkIfUserExists(String username){
        boolean userExists = false;
        Connection conn = SqlConnect.connect(DBLOGINLOCATION);
        String[][] loginInfo = SqlQuery.queryStatement(conn, "SELECT * FROM Login WHERE username=\'" + username + "\'");
        if (loginInfo.length > 0) {
            userExists = true;
        }
        return userExists;
    }
    
    public boolean deleteLoginUser(String username){
    	boolean deleted = false;
    	if (logintextfield.getText().isEmpty()){
    		userNullDialog();
    	} else if (checkIfUserExists(username)){
    		Connection conn = SqlConnect.connect(DBLOGINLOCATION);
    		SqlQuery.deleteLoginUser(conn, username);
    		deleted = true;
    	} else {
    		nonExistingUserNameDialog();
    	}
    	
    	return deleted;
    }
    
    protected void nonExistingUserNameDialog() {
        JOptionPane.showMessageDialog(panel, "Username Does Not Exist");
    }
    
    protected void userNullDialog() {
        JOptionPane.showMessageDialog(panel, "Username is NULL");
    }
}
