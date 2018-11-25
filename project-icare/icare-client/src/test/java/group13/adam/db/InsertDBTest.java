package group13.adam.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import group13.adam.headermap.HeaderMap;

public class InsertDBTest {
	
	InsertFormDB insert = new InsertFormDB();
	HeaderMap hm = new HeaderMap();
	
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
    	String url = "jdbc:sqlite:../icare-db/testdb.db";
        Connection conn = DriverManager.getConnection(url);
		Statement st = conn.createStatement();
		st.executeUpdate("DELETE FROM InfoForum");
		st.close();
		conn.close();
	}
	
	@Test
	@DisplayName("Test inserting one row")
	void test1Row() throws SQLException{
		String[] test = new String[90];
		for (int i = 0; i < test.length; i++)
			test[i] = "test" + i;
		insert.insert(test, "testdb.db");
		
		String url = "jdbc:sqlite:../icare-db/testdb.db";
        Connection conn = DriverManager.getConnection(url);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from InfoForum");
		
		// compare the list of strings to the db row
		int count = 0;
		for(String s: hm.getHeaderMap().keySet()){
			assertEquals(rs.getString(s), test[count]);
			count++;
		}
		rs.close();
		st.close();
		conn.close();
	}
	
	@Test
	@DisplayName("Test inserting two rows")
	void test2Rows() throws SQLException{
		String[] test = new String[90];
		for (int i = 0; i < test.length; i++)
			test[i] = "test" + i;
		insert.insert(test, "testdb.db");
		
		for (int i = 0; i < test.length; i++)
			test[i] = "bleh" + i;
		insert.insert(test, "testdb.db");
		
		String url = "jdbc:sqlite:../icare-db/testdb.db";
        Connection conn = DriverManager.getConnection(url);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from InfoForum");
		
		// compare the list of strings to the db row
		int count = 0;
		for(String s: hm.getHeaderMap().keySet()){
			assertEquals(rs.getString(s), "test" + count);
			count++;
		}
		
		// move to next row
		rs.next();	// moves to the first row of db
		rs.next();	// moves to the second row of db
		count = 0;
		for(String s: hm.getHeaderMap().keySet()){
			assertEquals(rs.getString(s), "bleh" + count);
			count++;
		}
		
		
		rs.close();
		st.close();
		conn.close();
	}
	
	@AfterAll
	static void deletedb(){
		File file = new File("../icare-db/testdb.db");
		file.delete();
	}
	
}
