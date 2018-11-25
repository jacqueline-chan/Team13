package group13.bob.table;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import group13.bob.table.logincomponents.Buttons;
import group13.bob.table.logincomponents.Labels;

public class DeleteUser extends JFrame{
	JPanel panel;
    JTextField logintextfield;
    
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
}
