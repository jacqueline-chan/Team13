package group13.bob.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SqlQueryTest {
	
	// clear test DB before each test
	@BeforeEach
	void testBeforeEach() throws SQLException{
		Connection conn = SqlConnect.connect();
		Statement st = conn.createStatement();
		st.executeUpdate("DELETE FROM InfoForum");
		st.close();
		conn.close();
	}
	
	@Test
	@DisplayName("Test empty DB")
	void testEmptyDB(){
		Connection conn = SqlConnect.connect();
		String[][] result = SqlQuery.selectAll(conn, "InfoForum");
		assertEquals(result.length, 0);
	}
}
