package group13.bob.sqlite;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlConnect {

    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


}
