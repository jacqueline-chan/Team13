package group13.bob.sqlite;

import java.sql.*;
import java.util.ArrayList;

public class SqlQuery {

    private static final String DEFAULTSTARTDATE = "1000-1-20";
    private static final String DEFAULTENDDATE = "2099-10-11";
    private static final String[] DEFAULTGROUPBY = new String[]{
            "language_of_service", "official_language_of_preference", "referred_by"
    };

    public static String[][] selectAll(Connection conn, String formName) {

        String[][] selectAllTable2D;

        String sqlQuery = "SELECT * FROM " + formName + " WHERE Start_Date_of_Service BETWEEN \'" + DEFAULTSTARTDATE +
                "\' AND \'" + DEFAULTENDDATE + "\'";
        selectAllTable2D = queryStatement(conn, sqlQuery);

        return selectAllTable2D;
    }

    public static ArrayList<String[][]> defaultTemplate(Connection conn, String formName) {
        ArrayList<String[][]> groupByTables = new ArrayList();

        groupByTables = queryTemplate(conn, formName, DEFAULTGROUPBY, DEFAULTSTARTDATE, DEFAULTENDDATE);

        return groupByTables;
    }

    public static ArrayList<String[][]> queryTemplate(Connection conn, String formName, String[] selectedTables,
            String startDate, String endDate) {
        ArrayList<String[][]> groupByTables = new ArrayList();

        for (String groupByTable : selectedTables) {
            String sqlQuery = "SELECT COUNT(unique_identifier), " + groupByTable +
                    "  FROM " + formName +
                    " WHERE Start_Date_of_Service BETWEEN \'" + startDate +
                    "\' AND \'" + endDate + "\'" +
                    " GROUP BY " + groupByTable +
                    " ORDER BY COUNT(unique_identifier) DESC";
            groupByTables.add(queryStatement(conn, sqlQuery));
        }

        return groupByTables;
    }

    public static String[][] queryStatement(Connection conn, String sqlQuery) {
        ArrayList<String[]> table = new ArrayList();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery)
        ) {
            ResultSetMetaData rsmd;
            while (rs.next()) {
                rsmd = rs.getMetaData();
                int numOfCol = rsmd.getColumnCount();
                do {
                    ArrayList<String> currentRow = new ArrayList();

                    for (int columnNum = 1; columnNum <= numOfCol; columnNum++) {
                        String columnData = String.valueOf (rs.getObject(columnNum));
                        currentRow.add(columnData);
                    }
                    table.add(toStringArray(currentRow));

                } while (rs.next());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return toStringArray2D(table);
    }

    private static String[][] toStringArray2D(ArrayList<String[]> arrayListStringArray) {

        String[][] stringArray2D = new String[arrayListStringArray.size()][];
        stringArray2D = arrayListStringArray.toArray(stringArray2D);

        return stringArray2D;
    }

    private static String[] toStringArray(ArrayList<String> arrayListString) {
        String[] stringArray = new String[arrayListString.size()];
        stringArray = arrayListString.toArray(stringArray);
        return stringArray;
    }
}
