package group13.bob.sqlite;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnect {

    private static final String DBLOCATION = "../icare-db/test.db";

    public static Connection connect() {
        // SQLite connection string
        Path currentDir = Paths.get(".");
        System.out.println(currentDir.toAbsolutePath());
        String url = "jdbc:sqlite:" + DBLOCATION;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static Connection connect(String dbLocation) {
        // SQLite connection string
        Path currentDir = Paths.get(".");
        System.out.println(currentDir.toAbsolutePath());
        String url = "jdbc:sqlite:" + dbLocation;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


}