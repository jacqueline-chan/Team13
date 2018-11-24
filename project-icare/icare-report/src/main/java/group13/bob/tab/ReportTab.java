package group13.bob.tab;

import group13.bob.table.Table;
import group13.bob.table.TableConstructor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class ReportTab extends JFrame {

    private JTabbedPane tab = new JTabbedPane();
    private JTable reportTable;
    private TableColumn column;

    private String[] emptyValue = {"", "", "", ""};
    private String topLanguages = "Top 10 Language of Service:";
    private String perferredOfficialLanguage = "Perferred Official Language:";
    private String referredBy = "Referred By";
    private String totalCounts = "                          Total Counts(all clients)";
    
    private int level; // 1 is admin, 2 is intermediate, 3 is basic
    JPanel plus;
    JButton showTable;

    // this is how the data should look like when extract data from database
    private String[] dateRange = new String[]{"", "2013","2014", "2015", "2016", "2017", "2018"};
    private String[][] topLanguagesTestValues =
            {{"English", "10", "20", "30", "40", "50", "60"}, {"English", "10", "20", "30", "40", "50", "60"},
                    {"English", "10", "20", "30", "40", "50", "60"}, {"English", "10", "20", "30", "40", "50", "60"},
                    {"English", "10", "20", "30", "40", "50", "60"},
                    {"English", "10", "20", "30", "40", "50", "60"}, {"English", "10", "20", "30", "40", "50", "60"},
                    {"English", "10", "20", "30", "40", "50", "60"}, {"English", "10", "20", "30", "40", "50", "60"},
                    {"English", "10", "20", "30", "40", "50", "60"}, {"English", "10", "20", "30", "40", "50", "60"}};
    private String[][] perferredLanguageTestValues =
            {{"English", "10", "20", "30", "40", "50", "60"}, {"French", "10", "20", "30", "40", "50", "60"},
                    {"Unknown", "10", "20", "30", "40", "50", "60"}};
    private String[][] referredByTestValues =
            {{"English", "10", "20", "30", "40", "50", "60"}, {"French", "10", "20", "30", "40", "50", "60"},
                    {"Unknown", "10", "20", "30", "40", "50", "60"}};
    private String[][] totalCountsTestForTopLanguagesValues = {{"500", "600", "700", "800", "40", "50", "60"}};
    private String[][] totalCountsTestForPerferredLanguagesValues =
            {{"5000", "6000", "7000", "8000", "400", "500", "600"}};

    public void runReportTab() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Report Tabs");
        setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
        setBounds(200, 100, 1518, 878);
        setLayout(null);

        int n = dateRange.length-1;
        String[] sampleRange=new String[n];
        System.arraycopy(dateRange,1,sampleRange,0,n);

        topLanguagesTestValues = TableConstructor.getTopTableFromRanges(sampleRange,"InfoForum", "language_of_service",10);
        perferredLanguageTestValues = TableConstructor.getTopTableFromRanges(sampleRange,"InfoForum", "official_language_of_preference",4);
        referredByTestValues = TableConstructor.getTopTableFromRanges(sampleRange,"InfoForum", "referred_by",3);
        JPanel report1 = new JPanel();
        report1.setBorder(new EmptyBorder(5, 5, 5, 5));
        report1.setLayout(new BorderLayout());
        tab.addTab("report1", null, report1, "first");
        JScrollPane scrollPane = new JScrollPane();

        int totalNumberOfRows =
                topLanguagesTestValues.length + perferredLanguageTestValues.length + referredByTestValues.length + 6;
        int topLanguageRow, col, perferredLanguageRow, referRow;

        // Let table be not editable
        DefaultTableModel reportTableModel =
                new DefaultTableModel(null, dateRange) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
        reportTable = new JTable(reportTableModel);
        // First initialize the table with all empty values so that later can override those values by row and column
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

        // Initialize the tile of first part of the report (Top 10 Languages)
        reportTable.setValueAt(topLanguages, 0, 0);
        // Put related data into the table by given a range of number of rows
        for (topLanguageRow = 1; topLanguageRow <= topLanguagesTestValues.length; topLanguageRow++) {
            for (col = 0; col < dateRange.length; col++) {
                reportTable.setValueAt(topLanguagesTestValues[topLanguageRow - 1][col], topLanguageRow, col);
            }
        }
        // Initialize total counts of top languages
        reportTable.setValueAt(totalCounts, topLanguageRow, 0);
        addTotalCountsData(topLanguageRow, totalCountsTestForTopLanguagesValues);

        // Initialize the second part of the report which is preferred official languages
        reportTable.setValueAt(perferredOfficialLanguage, topLanguageRow + 1, 0);
        perferredLanguageRow = setReportValue(topLanguageRow, perferredLanguageTestValues);
        // Initialize total counts of preferred official languages
        reportTable.setValueAt(totalCounts, perferredLanguageRow, 0);
        addTotalCountsData(perferredLanguageRow, totalCountsTestForPerferredLanguagesValues);

        // Initialize refer by part
        reportTable.setValueAt(referredBy, perferredLanguageRow + 1, 0);
        referRow = setReportValue(perferredLanguageRow, perferredLanguageTestValues);

        scrollPane.setViewportView(reportTable);
        report1.add(scrollPane, BorderLayout.CENTER);

        showTable = new JButton("Show Table");
        showTable.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                lauchTableGui();
            }
        }); ;
        report1.add(showTable, BorderLayout.SOUTH);

        JLabel label = new JLabel("This is Report1");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel report2 = new JPanel();
        tab.addTab("report2", null, report2, "second");

        JPanel report3 = new JPanel();
        tab.addTab("report3", null, report3, "third");

        plus = new JPanel();
        tab.addTab("+", null, plus, "plus");

        tab.setSelectedIndex(0);
        setLayout(new GridLayout(1, 1));
        
        checklevel(this);
        setlevel();
        add(tab);
    }

    private void addTotalCountsData(int rowNumber, String[][] data) {
        for (int column = 1; column < dateRange.length; column++) {
            reportTable.setValueAt(data[0][column], rowNumber, column);
        }
    }

    public int setReportValue(int start, String[][] inputData) {
        int startRowNumber, endRowNumber, col, index = 0;
        int upTo = start + inputData.length + 2;
        // plus 2 because there is a title for each part and there is a total count from last part of report
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
  		  showTable.setVisible(true);
  	  }
  	  else if (level == 2){
  		  showTable.setVisible(false);
  	  } else { // (level == 3) default
  		  tab.remove(plus);
  		  showTable.setVisible(false);
  	  }
    }

    protected void lauchTableGui() {
        try {
            Table frame = new Table();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public static void main(String[] args) {
//        ReportTab frame = new ReportTab();
//        frame.runReportTab();
//        frame.setVisible(true);
//    }
}

