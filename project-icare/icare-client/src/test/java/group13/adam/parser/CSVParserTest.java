package group13.adam.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import group13.cscc01.forms.InfoForm;

public class CSVParserTest {

	CSVParser testParser = new CSVParser();
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
	@DisplayName("testing a CSV file that does not exist")
	void testNoMessage() {
		assertThrows(IOException.class, ()->{
			testParser.parseFile("doesnotexist.txt", "testdb.db");
		}, "exception was thrown for a non-existant CSV file");
	}
	
	@Test
	@DisplayName("test Insert 1 line")
	void test1Line() throws SQLException, IOException{
		InfoForm form = testParser.parseFile("./src/test/java/group13/adam/parser/Test1User.csv", "testdb.db");
		String url = "jdbc:sqlite:../icare-db/testdb.db";
        Connection conn = DriverManager.getConnection(url);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from InfoForum");
		// compare the info form to the db row
		for(String s: hm.getHeaderMap().keySet()){
			assertEquals(rs.getString(s), form.getInfoMap().get(hm.getHeaderMap().get(s)));
		}
		rs.close();
		st.close();
		conn.close();
		
	}
	
	@Test
	@DisplayName("test Insert 50 lines")
	void testMultipleLines() throws SQLException, IOException{
		testParser.parseFile("./src/test/java/group13/adam/parser/infoforum.csv", "testdb.db");
		String url = "jdbc:sqlite:../icare-db/testdb.db";
        Connection conn = DriverManager.getConnection(url);
		Statement st = conn.createStatement();
		// want to make sure that we have 50 rows in db now
		ResultSet rs = st.executeQuery("select COUNT(*) from InfoForum");
		assertEquals(rs.getInt(1), 50);
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
