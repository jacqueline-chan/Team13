package group13.bob.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnect {

    private static final String DBLOCATION = "./project-icare/icare-client/src/group13/adam/db/test.db";

    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:" + DBLOCATION;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


}
