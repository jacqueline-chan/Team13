package tab;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;


public class ReportTab extends JFrame{
	
	private JTabbedPane tab = new JTabbedPane();

	public ReportTab() {
		
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	setTitle("Report Tabs");
    	setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
    	setBounds(200, 100, 1518, 878);
		setLayout(null);
		
		JPanel report1 = new JPanel();
		tab.addTab("report1", null, report1, "first");
		JButton submit1 = new JButton("Submit");
		JButton cancel1 = new JButton("Cancel");
		submit1.setBounds(100, 450, 100, 50);
		cancel1.setBounds(300, 450, 100, 50);
		report1.add(submit1);
		report1.add(cancel1);
        JLabel label = new JLabel("This is Report1");
        label.setHorizontalAlignment(SwingConstants.CENTER);
		report1.add(label);
		
		JPanel report2 = new JPanel();
		tab.addTab("report2", null, report2, "second");
		JButton submit2 = new JButton("Submit");
		JButton cancel2 = new JButton("Cancel");
		report2.add(submit2);
		report2.add(cancel2);
		
		JPanel report3 = new JPanel();
		tab.addTab("report3", null, report3, "third");
		JButton submit3 = new JButton("Submit");
		JButton cancel3 = new JButton("Cancel");
		report3.add(submit3);
		report3.add(cancel3);
		
		tab.setSelectedIndex(0);
		setLayout(new GridLayout(1, 1));
		add(tab);
	}
}
