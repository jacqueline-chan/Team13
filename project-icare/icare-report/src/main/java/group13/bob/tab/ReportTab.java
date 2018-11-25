package group13.bob.tab;

import group13.bob.table.DeleteUser;
import group13.bob.table.SignUp;
import group13.bob.table.Table;
import group13.bob.table.TableConstructor;
import group13.bob.templates.FormArray;
import group13.bob.templates.ReportTemplates;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import group13.bob.files.*;

public class ReportTab extends JFrame {

  private String accessLevel = "";
  private int level; // 1 is admin, 2 is intermediate, 3 is basic

  private JTabbedPane tab = new JTabbedPane();
  private JTable reportTable;
  private TableColumn column;
  private int lastTab;
  private String[] emptyValue = {"", "", "", ""};
  private String[][][] fields;
  private String totalCounts =
      "                          Total Counts(all clients)";
  private JButton plus;
  private JButton importButton;
  private JButton signUpTemplate;
  private JButton deleteUserTemplate;
  JButton tableButton;
  
  // this is how the data should look like when extract data from database
  private String[] dateRange =
      new String[] {"", "2013", "2014", "2015", "2016", "2017", "2018"};

  public void runReportTab() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    importButton = new JButton("Import a template");
    ReportTab temp = this;
    importButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        FileManager.getFile(temp);
      }
    });
    lastTab = 2;
    plus = new JButton("+");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setTitle("Report Tabs");
    setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
    setBounds(200, 100, 1518, 878);
    setLayout(null);

    JLabel label = new JLabel("This is Report1");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    JPanel report = new JPanel();
    report.setBorder(new EmptyBorder(5, 5, 5, 5));
    report.setLayout(new BorderLayout());
    tab.addTab("report1", null, report, "First");
    populateTable(new String[] {"Language of Service", "Official Language of Preference", "Referred By"}
    , "report1", report);
    tableButton = new JButton("Show Table");
    tableButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        launchTableGui();
      }
    });
    
    signUpTemplate = new JButton("Create Other User Accounts");
    signUpTemplate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
    		try {
    	        SignUp signup = new SignUp();
    	        signup.showlevels();
    	        signup.setVisible(true);
    		} catch (Exception error) {
    			error.printStackTrace();
    		}
        }
      });
    
    deleteUserTemplate = new JButton("Delete User Accounts");
    deleteUserTemplate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
    		try {
    	        DeleteUser delete = new DeleteUser();
    	        delete.setVisible(true);
    		} catch (Exception error) {
    			error.printStackTrace();
    		}
        }
      });
    
    JPanel templatePanel = new JPanel(new GridLayout(0, 1));
    templatePanel.add(tableButton);
    templatePanel.add(signUpTemplate);
    templatePanel.add(deleteUserTemplate);
    
    report.add(templatePanel, BorderLayout.PAGE_END);
    JPanel report2 = new JPanel();
    tab.addTab("report2", null, report2, "second");

    JPanel report3 = new JPanel();
    tab.addTab("report3", null, report3, "third");

    // Add the plus button to the tabs.
    plus.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ReportTemplates.CreateTemplatePopUp(temp);
      }
    });
    tab.addTab(null, null, null, null);
    lastTab++;
    setPlus();

    tab.setSelectedIndex(0);
    setLayout(new GridLayout(1, 1));
    
    checklevel(this);
    setlevel();

    add(tab);
  }

  public void setNewTab(String name, String[] template) {
    JPanel newReport = new JPanel();
    newReport.setLayout(new BorderLayout());
    newReport.setBorder(new EmptyBorder(5, 5, 5, 5));
    setPlus();
    tab.setTitleAt(lastTab - 2, name);
    tab.setToolTipTextAt(lastTab - 2, "The report for " + name);
    // Let table be not editable
    tab.setComponentAt(lastTab - 2, newReport);
    populateTable(template, name, newReport);
  }

  private void createTable(int totalNumberOfRows) {
    DefaultTableModel reportTableModel =
        new DefaultTableModel(null, dateRange) {
          @Override
          public boolean isCellEditable(int row, int column) {
            return false;
          }
        };
    reportTable = new JTable(reportTableModel);
    // First initialize the table with all empty values so that later can
    // override those values by row and column
    for (int c = 0; c < totalNumberOfRows; c++) {
      reportTableModel.addRow(emptyValue);
    }
    // Set width of each column
    reportTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    for (int i = 0; i < dateRange.length; i++) {
      column = reportTable.getColumnModel().getColumn(i);
      column.setPreferredWidth(200);
    }
    // Let the order of each column cannot be changed
    reportTable.getTableHeader().setReorderingAllowed(false);
    reportTable.setFillsViewportHeight(true);
  }

  private void populateTable(String[] fieldNames, String name, JPanel report) {
    int n = dateRange.length - 1;
    String[] sampleRange = new String[n];
    System.arraycopy(dateRange, 1, sampleRange, 0, n);
    int totalNumberOfRows = 0;
    fields = new String[fieldNames.length][][];
    HashMap<String, String> infoMap = (new FormArray()).getInfoMap();
    for (int index = 0; index < fieldNames.length; index++) {
     // System.out.println(fieldNames[index]);
      this.fields[index] = TableConstructor.getTopTableFromRanges(sampleRange,
          "InfoForum", infoMap.get(fieldNames[index]), 5);
      // Adds additional 2 rows for total numbers and an empty row
      totalNumberOfRows = totalNumberOfRows + this.fields[index].length + 2;
    }
    totalNumberOfRows--;
    createTable(totalNumberOfRows);
    
    JScrollPane scrollPane = new JScrollPane();

    // Let table be not editable

    int totRow = 0;
    int numFields = 0;
    System.out.println(fieldNames.length);
    while (numFields < fieldNames.length) {
      // Initialize the tile of first part of the report (Top 10 Languages)
      reportTable.setValueAt("Top " + fieldNames[numFields] + " Results", totRow, 0);
      totRow++;
      // Put related data into the table by given a range of number of rows
      for (int row = 0; row < fields[numFields].length; row++) {
        for (int col = 0; col < dateRange.length; col++) {
          reportTable.setValueAt(fields[numFields][row][col], totRow, col);
        }
        totRow++;
      }
      // Initialize total counts of top languages
      totRow = totRow + 1;
      numFields++;
    }
    scrollPane.setViewportView(reportTable);
    report.add(scrollPane, BorderLayout.CENTER);
    numFields++;


  }

  private void addTotalCountsData(int rowNumber, String[][] data) {
    for (int column = 1; column < dateRange.length; column++) {
      reportTable.setValueAt(data[0][column], rowNumber, column);
    }
  }

  public int setReportValue(int start, String[][] inputData) {
    int startRowNumber, endRowNumber, col, index = 0;
    int upTo = start + inputData.length + 2;
    // plus 2 because there is a title for each part and there is a total count
    // from last part of report
    start += 2;
    for (startRowNumber = start; startRowNumber < upTo; startRowNumber++) {
      for (col = 0; col < dateRange.length; col++) {
        reportTable.setValueAt(inputData[index][col], startRowNumber, col);
      }
      index++;
    }
    endRowNumber = startRowNumber;
    return endRowNumber;
  }
  
  public void setAccessLevel(String accessLevel) {
      this.accessLevel = accessLevel;
  }

  protected void launchTableGui() {
    try {
      Table frame = new Table();
      frame.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void setPlus() {
    tab.setTitleAt(lastTab, "");
    tab.setToolTipTextAt(lastTab, "Click to import an existing template");
    tab.setTabComponentAt(lastTab, importButton);
    tab.addTab(null, null, null, "Click to add another report");
    lastTab++;
    tab.setTabComponentAt(lastTab, plus);
  }
  
  public void checklevel(Component contentPane){ // TEMPORARY FUNCTION TO MAKE USER LEVELS WORK, SHOULD call a function that changes the level of the user
  	  String s = this.accessLevel;
  	  //If a string was returned, say so.
  	  if ((s != null) && (s.length() > 0)) {
  		  System.out.println("user level: " + s);
  		  if (s.equals("ADMIN")) {
  			  level=1;
  		  } else if (s.equals("MODERATOR")){
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
  		  tableButton.setVisible(true);
  		  signUpTemplate.setVisible(true);
  		  deleteUserTemplate.setVisible(true);
  		  importButton.setVisible(true);
  	  }
  	  else if (level == 2){
  		  tableButton.setVisible(false);
  		  signUpTemplate.setVisible(false);
  		  deleteUserTemplate.setVisible(false);
  		  importButton.setVisible(true);

  	  } else { // (level == 3) default
  		  tableButton.setVisible(false);
  		  signUpTemplate.setVisible(false);
  		  deleteUserTemplate.setVisible(false); 		  
  		  importButton.setVisible(false);
  		  plus.setVisible(false);

  	  }
    }

}

