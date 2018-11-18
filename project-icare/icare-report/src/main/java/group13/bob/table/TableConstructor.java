package group13.bob.table;

import group13.bob.sqlite.SqlConnect;
import group13.bob.sqlite.SqlQuery;

import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;

public class TableConstructor {
    private static HashMap<String, Integer> languageHashMap = new HashMap<String, Integer>();


    public static String[][] getTopTableFromRanges(String[] dateRange, String formName, String tableColumn,
            int topNum) {
        String[][] constructedTable;
        String[] Table = {tableColumn};
        Connection conn = SqlConnect.connect();
        String[][] top10Table;
        String startDateRange = dateRange[0] + "-01-01";
        String endDateRange = dateRange[dateRange.length - 1] + "-12-31"; ;

        String[][] rawTable = (SqlQuery.queryTemplate(conn, formName, Table, startDateRange, endDateRange)).get(0);

        //String sqlQuery = "SELECT COUNT(unique_identifier) FROM InfoForum WHERE Start_Date_of_Service BETWEEN \""+startDateRange+"\" AND \""+endDateRange+"\"";
        //String topTable[][] = SqlQuery.queryStatement(conn, sqlQuery);

        constructedTable = constructTopTable(topNum, dateRange.length + 1, rawTable);
        int coloumnNum = 1;
        for (String dateRangeYear : dateRange) {
            String startDate = dateRangeYear + "-01-01";
            String endDate = dateRangeYear + "-12-31";
            String[][] yearTable = (SqlQuery.queryTemplate(conn, formName, Table, startDate, endDate)).get(0);

            if (yearTable.length > 1){
                for (int i = 0; i < yearTable.length; i++) {

                    int rowNum = languageHashMap.get(yearTable[i][1]);
                    if (rowNum < topNum){
                        constructedTable[rowNum][coloumnNum] = yearTable[i][0];
                    } else{
                        int otherInteger = Integer.parseInt(constructedTable[topNum][coloumnNum]);
                        otherInteger += Integer.parseInt(yearTable[i][0]);
                        constructedTable[topNum][coloumnNum] = String.valueOf(otherInteger);
                    }
                }
            }
            coloumnNum++;
        }

        return constructedTable;
    }

    private static String[][] constructTopTable(int topNum, int columnNum, String[][] rawTable) {
        String[][] topTable = new String[topNum + 1][columnNum];
        for (String[] row : topTable) {
            Arrays.fill(row, "0");
        }
        int topAmount = 0;
        int otherAmount = 0;
        for (int i = 0; i < topNum; i++) {
            topTable[i][0] = rawTable[i][1];
            languageHashMap.put(rawTable[i][1], i);
            topAmount += Integer.parseInt(rawTable[i][0]);
        }
        for (int i = topNum; i < rawTable.length; i++) {
            //otherAmount += Integer.parseInt(rawTable[i][1]);
            languageHashMap.put(rawTable[i][1], i);
        }
        topTable[topNum][0] = "Others";
        return topTable;
    }
}
