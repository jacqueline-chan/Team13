package group13.bob.table;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import group13.bob.sqlite.SqlConnect;
import group13.bob.sqlite.SqlQuery;
import group13.bob.table.logincomponents.Buttons;
import group13.bob.table.logincomponents.Labels;


public class SignUp extends JFrame{
    JPanel panel;
    JTextField logintextfield;
    JTextField passwordtextfield;
    JLabel levelLabel;
    JComboBox levelList;
    String level = "DEFAULT";
    private static final String DBLOGINLOCATION = "../icare-db/login.db";
	
	public SignUp() {
        panel = new JPanel();
        panel.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        setBounds(500, 100, 370, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("SignUpPage");
        
        Buttons button = new Buttons();
        Labels labels = new Labels();
        
        labels.instruction(panel);
        labels.loginpictureLabel(panel);
        labels.usernameLabel(panel);
        labels.passwordLabel(panel);
        logintextfield = labels.usernameLabeTextfield(panel);
        passwordtextfield = labels.passwordLabelTextfield(panel);

        JButton createSubmitButton = button.createSubmitButton(panel);
        createSubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	level = levelList.getSelectedItem().toString(); // by default, this would be DEFAULT
            	insertLoginUser(logintextfield.getText(), passwordtextfield.getText(), level);
            }
        });

        JButton backButton = button.createBackButton(panel);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logintextfield.setText("");
                passwordtextfield.setText("");
                dispose();
            }
        });
        
        levelLabel = labels.levelLabel(panel);
        
        String[] levelStrings = { "ADMIN", "DEFAULT", "MODERATOR"};
        levelList = new JComboBox(levelStrings);
        levelList.setSelectedIndex(1);
        levelList.setBounds(200,450,130,30);
        panel.add(levelList);
 
        setContentPane(panel);

	}
	
	public void hidelevels(){
        levelLabel.setVisible(false);
        levelList.setVisible(false);
	}
	
	public void showlevels(){
        levelLabel.setVisible(true);
        levelList.setVisible(true);
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
    
    public boolean insertLoginUser(String username, String password, String user_access){
    	boolean inserted = false;
    	
    	if (logintextfield.getText().isEmpty() | passwordtextfield.getText().isEmpty()){
    		userNameNullDialog();
    	} else if (!checkIfUserExists(username)){
    		Connection conn = SqlConnect.connect(DBLOGINLOCATION);
    		SqlQuery.insertLoginUser(conn, username, password, user_access);
    		inserted = true;
    	} else {
    		unsuccessfulUserNameDialog();
    	}
        return inserted;
    }
    
    protected void unsuccessfulUserNameDialog() {
        JOptionPane.showMessageDialog(panel, "Username Already Exists");
    }

    protected void userNameNullDialog() {
        JOptionPane.showMessageDialog(panel, "Username or Password cannot be NULL");
    } 
    
    protected void userNullDialog() {
        JOptionPane.showMessageDialog(panel, "Username is NULL");
    }

}
