package group13.bob.sqlite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SqlQueryTest {
	
	@BeforeAll
	static void createDB(){
		String url = "jdbc:sqlite:../icare-db/testdb.db";
		try {
			BufferedReader in = new BufferedReader(new FileReader("../icare-db/sql/SetupBlankTestTable.sql"));
			String str;
			StringBuffer sb = new StringBuffer();
			while ((str = in.readLine()) != null){
				sb.append(str + "\n");
			}
			in.close();
			Connection conn = DriverManager.getConnection(url);
			if (conn != null){
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sb.toString());
				stmt.close();
			}
			conn.close();
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	// clear test DB before each test
	@BeforeEach
	void testBeforeEach() throws SQLException{
		Connection conn = SqlConnect.connect("../icare-db/testdb.db");
		Statement st = conn.createStatement();
		st.executeUpdate("DELETE FROM InfoForum");
		st.close();
		conn.close();
	}
	
	@Test
	@DisplayName("Test empty DB")
	void testEmptyDB(){
		Connection conn = SqlConnect.connect("../icare-db/testdb.db");
		String[][] result = SqlQuery.selectAll(conn, "InfoForum");
		assertEquals(result.length, 0);
	}
	
	@AfterAll
	static void deletedb(){
		File file = new File("../icare-db/testdb.db");
		file.delete();
	}
	
}
