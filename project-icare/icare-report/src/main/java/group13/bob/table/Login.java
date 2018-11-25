package group13.bob.table;

import group13.bob.sqlite.SqlConnect;
import group13.bob.sqlite.SqlQuery;
import group13.bob.tab.ReportTab;
import group13.bob.table.logincomponents.Buttons;
import group13.bob.table.logincomponents.Labels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Login extends JFrame {
    private static final String DBLOGINLOCATION = "../icare-db/login.db";
    private String accessLevel = "";

    JPanel panel;
    //Container container=getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField logintextfield;
    JTextField passwordtextfield;
    private String password;
    String username;

    public Login() {
        panel = new JPanel();
        panel.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        setBounds(500, 100, 370, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LoginPage");

        Buttons button = new Buttons();
        Labels labels = new Labels();

        labels.loginpictureLabel(panel);
        labels.usernameLabel(panel);
        labels.passwordLabel(panel);
        logintextfield = labels.usernameLabeTextfield(panel);
        passwordtextfield = labels.passwordLabelTextfield(panel);

        JButton createSignUpButton = button.createSignUpButton(panel);
        createSignUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    SignUp frame = new SignUp();
                    frame.hidelevels();
                    frame.setVisible(true);
                } catch (Exception error) {
                    error.printStackTrace();
                }
            }
        });

        JButton cancelButton = button.createCancelButton(panel);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logintextfield.setText("");
                passwordtextfield.setText("");
            }
        });
        JButton loginButton = button.createLoginButton(panel);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getCredentials();
                verifyCredentials();
            }
        });

        setContentPane(panel);
    }

    protected void getCredentials() {
        username = logintextfield.getText();
        password = passwordtextfield.getText();
    }

    protected void verifyCredentials() {
        Connection conn = SqlConnect.connect(DBLOGINLOCATION);
        String[][] loginInfo = SqlQuery.queryStatement(conn, "SELECT * FROM Login WHERE username=\'" + username + "\'");
        if (loginInfo.length == 0) {
            unsuccessfulLoginDialog();
        } else {
            if (password.equals(loginInfo[0][1])) {
                this.accessLevel = loginInfo[0][2];
                lauchTabGui();
            } else {
                unsuccessfulPasswordDialog();
            }

        }
    }

//    public boolean checkIfUserExists(String username){
//        boolean userExists = false;
//        Connection conn = SqlConnect.connect(DBLOGINLOCATION);
//        String[][] loginInfo = SqlQuery.queryStatement(conn, "SELECT * FROM Login WHERE username=\'" + username + "\'");
//        if (loginInfo.length == 0) {
//            userExists = true;
//        }
//        return userExists;
//    }

    protected void unsuccessfulLoginDialog() {
        JOptionPane.showMessageDialog(panel, "Login Not Found");

    }

    protected void unsuccessfulPasswordDialog() {
        JOptionPane.showMessageDialog(panel, "Wrong Password");

    }

    protected void lauchTabGui() {
        try {
            ReportTab frame = new ReportTab();
            frame.setAccessLevel(this.accessLevel);
            frame.runReportTab();
            frame.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
