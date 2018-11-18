package group13.bob.table;

import group13.bob.files.FileManager;
import group13.bob.sqlite.SqlConnect;
import group13.bob.sqlite.SqlQuery;
import group13.bob.tab.ReportTab;
import group13.bob.templates.ModifyReportTemplate;
import group13.bob.templates.ReportTemplates;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import static group13.bob.sqlite.SqlConnect.connect;

public class Table extends JFrame {

  private JPanel contentPane;
  private JTable table;
  private TableColumn column;
  
  private int level; // 1 is admin, 2 is intermediate, 3 is basic
  private JButton createTemplate;
  private JButton modifyTemplate;

  private static final String[] columnNames = {"Unique Identifier",
      "Date of Birth (YYYY-MM-DD)",
      "Postal Code where the service was received",
      "Start Date of Service (YYYY-MM-DD)", "Language of Service",
      "Official Language of Preference",
      "Type of Institution/Organization Where Client Received Services",
      "Referred By", "Services Received", "Total Length of Orientation",
      "Total Length of Orientation: Hours",
      "Total Length of Orientation: Minutes", "Number of Clients in Group",
      "Directed at a specific Target Group ",
      "Target Group: Children (0-14 yrs)", "Target Group: Youth (15-24 yrs)",
      "Target Group: Seniors", "Target Group: Gender-specific",
      "Target Group: Refugees",
      "Target Group: Ethnic/cultural/linguistic group",
      "Target Group: Deaf or Hard of Hearing",
      "Target Group: Blind or Partially Sighted",
      "Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)",
      "Target Group: Families/Parents",
      "Target Group: Clients with other impairments (physical, mental)",
      "Target Group: Clients with international training in a regulated profession",
      "Target Group: Clients with international training in a regulated trade",
      "Target Group: Official Language minorities", "Overview of Canada",
      "Overview of Canada Referrals", "Sources of Information",
      "Sources of Information Referrals", "Rights and Freedoms",
      "Rights and Freedoms Referrals", "Canadian Law and Justice",
      "Important Documents", "Important Documents Referrals",
      "Improving English or French", "Improving English or French Referrals",
      "Employment and Income", "Employment and Income Referrals", "Education",
      "Education Referrals", "Housing", "Housing Referrals", "Health",
      "Health Referrals", "Money and Finances", "Money and Finances Referrals",
      "Transportation", "Transportation Referrals", "Communications and Media",
      "Communications and Media Referrals", "Community Engagement",
      "Community Engagement Referrals", "Becoming a Canadian Citizen",
      "Becoming a Canadian Citizen Referrals", "Interpersonal Conflict",
      "Interpersonal Conflict Referrals",
      "Was Essential Skills and Aptitude Training Received as Part of this Service?",
      "Computer skills", "Document Use",
      "Interpersonal Skills and Workplace Culture", "Leadership Training",
      "Numeracy",
      "Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?",
      "Life Skills",
      "Rights and Responsibilities of Citizenship (based on discover Canada)",
      "Support Services Received", "Care for Newcomer Children", "Child 1: Age",
      "Child 1: Type of Care", "Child 2: Age", "Child 2: Type of Care",
      "Child 3: Age", "Child 3: Type of Care", "Child 4: Age",
      "Child 4: Type of Care", "Child 5: Age", "Child 5: Type of Care",
      "Transportation 2", "Provisions for Disabilities", "Translation",
      "Between", "And", "Interpretation", "Between 1", "And 2",
      "Crisis Counselling", "End Date of Service (YYYY-MM-DD)",
      "Reason for update"};

  public Table() {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
    setBounds(200, 100, 1518, 878);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle("Table");

    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout());
    Connection conn = SqlConnect.connect();
    String[][] tableValues = SqlQuery.selectAll(conn, "InfoForum");
    System.out.println(tableValues);

    // Let table be not editable
    DefaultTableModel tableModel =
        new DefaultTableModel(tableValues, columnNames) {
          @Override
          public boolean isCellEditable(int row, int column) {
            return false;
          }
        };

    table = new JTable(tableModel);

    // Set width of each column
    table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    for (int i = 0; i < columnNames.length ; i++) {
      column = table.getColumnModel().getColumn(i);
      column.setPreferredWidth(150);
    }
    // Let the order of each column cannot be changed
    table.getTableHeader().setReorderingAllowed(false);
    table.setFillsViewportHeight(true);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    RowSorter<TableModel> rowSorter =
        new TableRowSorter<TableModel>(tableModel);
    table.setRowSorter(rowSorter);

    // Set scroll pane always shows up
    JScrollPane scrollPane =
        new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    contentPane.add(scrollPane, BorderLayout.CENTER);
    setContentPane(contentPane);
    
    // Add the button for template.
    JPanel templatePanel = new JPanel(new GridLayout(0, 1));
    createTemplate = new JButton("Create a new template");
    modifyTemplate = new JButton("Modify an existing template");
    JButton backButton = new JButton("Close");
    
    createTemplate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ReportTemplates.CreateTemplatePopUp();
      }
    });
    
    modifyTemplate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
    		try {
    	        ModifyReportTemplate modify = new ModifyReportTemplate();
    	        modify.setVisible(true);
    		} catch (Exception error) {
    			error.printStackTrace();
    		}
        }
      });
    
    backButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e){
    		dispose();
    	}
    });
    
    /*JButton getTemplate = new JButton("Get an existing template");
    getTemplate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        FileManager.getFile(true);
      }
    });
    templatePanel.add(getTemplate);*/
    templatePanel.add(createTemplate);
    templatePanel.add(modifyTemplate);
    templatePanel.add(backButton);
    checklevel(contentPane);
    setlevel();
    add(templatePanel, BorderLayout.PAGE_END);
  }
  
  public void checklevel(Component contentPane){ // TEMPORARY FUNCTION TO MAKE USER LEVELS WORK, SHOULD call a function that changes the level of the user
	  //else if (function returns level == 2){
	  //} else {function retusn  (level == 3) default
	  Object[] possibilities = {"admin", "intermediate", "basic"};
	  String s = (String)JOptionPane.showInputDialog(contentPane,
			  "Select user level:\n",
	                      "Customized Dialog",
	                      JOptionPane.PLAIN_MESSAGE,
	                      null, possibilities,null);

	  //If a string was returned, say so.
	  if ((s != null) && (s.length() > 0)) {
		  System.out.println("user level: " + s);
		  if (s.equals("admin")) {
			  level=1;
		  } else if (s.equals("intermediate")){
			  level=2;
		  } else { // default to basic
			  level=3;
		  }
	  } else { 	  //If you're here, the return value was null/empty.
		  level=3; //default to basic
	  }
  }

  
  public void setlevel(){
	  if (level==1){
		  createTemplate.setVisible(true);
		  modifyTemplate.setVisible(true);
	  }
	  else if (level == 2){
		  createTemplate.setVisible(false);
		  modifyTemplate.setVisible(true);
	  } else { // (level == 3) default
		  createTemplate.setVisible(false);
		  modifyTemplate.setVisible(false);
	  }
  }
  

}