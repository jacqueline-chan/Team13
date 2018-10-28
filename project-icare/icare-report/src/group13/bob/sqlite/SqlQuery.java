package group13.bob.sqlite;

import java.sql.*;
import java.util.ArrayList;

public class SqlQuery {

    private static final String DEFAULTSTARTDATE = "2018-1-20";
    private static final String DEFAULTENDDATE = "2018-10-11";

    public static String[][] selectAll(Connection conn, String formName) {

        ArrayList<String[]> table = new ArrayList();
        String sql = "SELECT * FROM " + formName + " WHERE Start_Date_of_Service BETWEEN \'" + DEFAULTSTARTDATE +
                "\' AND \'" + DEFAULTENDDATE + "\'";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)
        ) {
            ResultSetMetaData rsmd;
            while (rs.next()) {
                rsmd = rs.getMetaData();
                int numOfCol = rsmd.getColumnCount();
                do {
                    ArrayList<String> currentRow = new ArrayList();

                    for (int columnNum = 1; columnNum <= numOfCol; columnNum++) {
                        String columnData = (String) rs.getObject(columnNum);
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
