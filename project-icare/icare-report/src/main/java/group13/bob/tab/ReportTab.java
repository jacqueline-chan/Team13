package group13.bob.tab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import group13.bob.templates.*;
import group13.bob.table.Table;


public class ReportTab extends JFrame{
	private JButton plus;
	private JTabbedPane tab = new JTabbedPane();
	private int lastTab;
	private final int WIDTH = 1518;
	private final int defaultWidth = 200;
	public ReportTab() {
	    lastTab = 2;
		plus = new JButton("+");
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	setTitle("Report Tabs");
    	setBounds(0, 0, (int) screenSize.getWidth(), (int)screenSize.getHeight());
    	setBounds(200, 100, WIDTH, 878);
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
		final ReportTab temp = this;
	        plus.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               ReportTemplates.CreateTemplatePopUp(temp);        
	            }
	        });
	    setPlus();
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
	public void setNewTab(String name, String[] template) {
	  JPanel newReport = new JPanel();
	  newReport.setLayout(new BorderLayout());
	  newReport.setBorder(new EmptyBorder(5, 5, 5, 5));
	  setPlus();
	  tab.setTitleAt(lastTab - 1, name);
	  tab.setToolTipTextAt(lastTab - 1, "The report for " + name);
	    // Let table be not editable
      tab.setComponentAt(lastTab - 1, newReport);
	    DefaultTableModel tableModel =
	        new DefaultTableModel(new String[][] {}, template) {
	          @Override
	          public boolean isCellEditable(int row, int column) {
	            return false;
	          }
	        };
	    JTable table = new JTable(tableModel);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
	    TableColumn column;
	    for (int i = 0; i < template.length ; i++) {
	      column = table.getColumnModel().getColumn(i);
	      // splits the width between cells such that the entire panel is
	      // covered.
	      int tempWidth = WIDTH/(template.length);
	      if (tempWidth > defaultWidth) {
	        column.setPreferredWidth(WIDTH/(template.length));
	      } else {
	        column.setPreferredWidth(defaultWidth);
	      }
	    }
	    table.getTableHeader().setReorderingAllowed(false);
	    table.setFillsViewportHeight(true);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    // Set scroll pane always shows up
	    JScrollPane scrollPane =
	        new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    newReport.add(scrollPane, BorderLayout.CENTER);

	}
	
	private void createTable(JPanel panel) {
	  
	}
	private void setPlus() {
	  tab.addTab(null, null, null, "Click to add another report");
	  lastTab++;
      tab.setTabComponentAt(lastTab, plus);
	}
    public static void main(String[] args) {
        ReportTab frame = new ReportTab();
        frame.setVisible(true);
    }
}

