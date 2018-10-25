package group13.bob.sqlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlQuery {

    public static String[][] selectAll(Connection conn, String formName){
        ArrayList<String[]> table = new ArrayList();
        String sql = "SELECT * FROM "+formName;

        try (
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            ResultSetMetaData rsmd;
            while (rs.next()) {
                rsmd = rs.getMetaData();

                int NumOfCol = rsmd.getColumnCount();

                while (rs.next()) {
                    ArrayList<String> currentRow = new ArrayList();

                    for (int i = 1; i <= NumOfCol; i++) {
                        String columnData= (String)rs.getObject(i);
                        currentRow.add(columnData);
                    }
                    String[] rowArray = new String[currentRow.size()];
                    rowArray = currentRow.toArray(rowArray);
                    table.add(rowArray);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Convert and return String[][]
        String[][] tableArray = new String[table.size()][];
        tableArray = table.toArray(tableArray);
        return tableArray;
    }
}
