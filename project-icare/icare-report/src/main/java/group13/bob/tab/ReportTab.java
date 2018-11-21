package group13.bob.tab;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import group13.bob.templates.*;
import group13.bob.table.Table;


public class ReportTab extends JFrame{
	
	private JTabbedPane tab = new JTabbedPane();

	public ReportTab() {
		
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	setTitle("Report Tabs");
    	setBounds(0, 0, (int) screenSize.getWidth(), (int)screenSize.getHeight());
    	setBounds(200, 100, 1518, 878);
		setLayout(null);
		
		JPanel report1 = new JPanel();
		tab.addTab("report1", null, report1, "first");
		JButton showTable = new JButton("Show Table");
		showTable.setBounds(100, 450, 100, 50);
		showTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lauchTableGui();
			}
		});;
		report1.add(showTable);
		JLabel label = new JLabel("This is Report1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel report2 = new JPanel();
		tab.addTab("report2", null, report2, "second");
		
		JPanel report3 = new JPanel();
		tab.addTab("report3", null, report3, "third");
		
		tab.addTab("", null, null, null);
	      JButton plus = new JButton("+");
	        plus.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               ReportTemplates.CreateTemplatePopUp();        
	            }
	        });
	        tab.setTabComponentAt(3, plus);
		tab.setSelectedIndex(0);
		setLayout(new GridLayout(1, 1));
		add(tab);
	}
	
	protected void lauchTableGui() {
		try {
			Table frame = new Table();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
        ReportTab frame = new ReportTab();
        frame.setVisible(true);
    }
}

