package group13.bob.templates;

import javax.swing.*;
import java.awt.*;

import group13.bob.tab.ReportTab;
import group13.bob.table.logincomponents.Buttons;
import group13.bob.table.logincomponents.Labels;

public class ModifyReportTemplate extends JFrame{
	JPanel panel;
    //Container container=getContentPane();
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField logintextfield;
    JTextField passwordtextfield;
    String password;
    String username;
    
	public ModifyReportTemplate(){
		panel = new JPanel();
		panel.setLayout(null);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
	    setBounds(500, 100, 370, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("ModifyPage");
		
		setContentPane(panel);
	}
	
//	protected void lauchTabGui() {
//		try {
//	        ReportTab frame = new ReportTab();
//	        frame.setVisible(true);
//	        dispose();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
