package group13.cscc01.Table;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class Table extends JFrame {
	
	private JPanel contentPane;
    private JTable table;
    private TableColumn column;
    
	private static final String[] columnNames = {"Unique Identifier", "Date of Birth (YYYY-MM-DD)", "Postal Code where the service was received", "Start Date of Service (YYYY-MM-DD)", 
			"Language of Service", "Official Language of Preference", "Type of Institution/Organization Where Client Received Services", "Referred By", 
			"Services Received", "Total Length of Orientation", "Total Length of Orientation: Hours", "Total Length of Orientation: Minutes", 
			"Number of Clients in Group", "Directed at a specific Target Group ", "Target Group: Children (0-14 yrs)", "Target Group: Youth (15-24 yrs)", 
			"Target Group: Seniors", "Target Group: Gender-specific", "Target Group: Refugees", "Target Group: Ethnic/cultural/linguistic group", 
			"Target Group: Deaf or Hard of Hearing", "Target Group: Blind or Partially Sighted", "Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)", 
			"Target Group: Families/Parents", "Target Group: Clients with other impairments (physical, mental)", 
			"Target Group: Clients with international training in a regulated profession", "Target Group: Clients with international training in a regulated trade", 
			"Target Group: Official Language minorities", "Overview of Canada", "Overview of Canada Referrals", "Sources of Information", 
			"Sources of Information Referrals", "Rights and Freedoms", "Rights and Freedoms Referrals", "Canadian Law and Justice", "Important Documents", 
			"Important Documents Referrals", "Improving English or French", "Improving English or French Referrals", "Employment and Income", 
			"Employment and Income Referrals", "Education", "Education Referrals", "Housing", "Housing Referrals", "Health", "Health Referrals", 
			"Money and Finances", "Money and Finances Referrals", "Transportation", "Transportation Referrals", "Communications and Media", 
			"Communications and Media Referrals", "Community Engagement", "Community Engagement Referrals", "Becoming a Canadian Citizen", 
			"Becoming a Canadian Citizen Referrals", "Interpersonal Conflict", "Interpersonal Conflict Referrals", 
			"Was Essential Skills and Aptitude Training Received as Part of this Service?", "Computer skills", "Document Use", 
			"Interpersonal Skills and Workplace Culture", "Leadership Training", "Numeracy", 
			"Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?", "Life Skills", 
			"Rights and Responsibilities of Citizenship (based on discover Canada)", "Support Services Received", "Care for Newcomer Children", "Child 1: Age", 
			"Child 1: Type of Care", "Child 2: Age", "Child 2: Type of Care", "Child 3: Age", "Child 3: Type of Care", "Child 4: Age", "Child 4: Type of Care", 
			"Child 5: Age", "Child 5: Type of Care", "Transportation 2", "Provisions for Disabilities", "Translation", "Between", "And", "Interpretation", 
			"Between 1", "And 2", "Crisis Counselling", "End Date of Service (YYYY-MM-DD)", "Reason for update" };
    
    public Table() {
    	
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
    	setBounds(200, 100, 1518, 878);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("Table");
    	
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        
        
    	String[][] tableValues = {{"1", "19980808", "3", "4", "346", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" ,"", "", "", 
    		"", "", "", "", "", "", "" ,"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", 
    		"", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", ""}, {"0", "19970904", "43634643", "456745", "56865", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" ,"", "", "", 
        		"", "", "", "", "", "", "" ,"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", 
        		"", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", ""}, {"15", "20000330", "346346", "456456", "346346", "456456", "", "", "", "", "", "", "", "", "", "", "", "", "", "" ,"", "", "", 
            		"", "", "", "", "", "", "" ,"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", 
            		"", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", ""},{"365346", "20010330", "3636", "356536", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" ,"", "", "", 
                		"", "", "", "", "", "", "" ,"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", 
                		"", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", ""},};
    
    	
    	// Let table be not editable
    	DefaultTableModel tableModel = new DefaultTableModel(tableValues, columnNames) {
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }   	
    	};
    	
    	table = new JTable(tableModel);
    	
    	// Set width of each column
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        for (int i = 0; i < 91; i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(150);
        }
        // Let the order of each column cannot be changed
        table .getTableHeader().setReorderingAllowed(false);
    	table.setFillsViewportHeight(true);
    	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    	
    	RowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(tableModel);
    	table.setRowSorter(rowSorter);
    	
    	// Set scroll pane always shows up
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        setContentPane(contentPane);
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Table frame = new Table();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
