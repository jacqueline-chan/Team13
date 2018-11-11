package group13.adam.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import group13.adam.headermap.HeaderMap;
import group13.cscc01.forms.InfoForm;

public class CSVParserTest {

	CSVParser testParser = new CSVParser();
	HeaderMap hm = new HeaderMap();
	

	@BeforeEach
	void testBeforeEach() throws SQLException{
    	String url = "jdbc:sqlite:../icare-db/test.db";
        Connection conn = DriverManager.getConnection(url);
		Statement st = conn.createStatement();
		st.executeUpdate("DELETE FROM InfoForum");
		//st.close();
		//conn.close();
	}
    
	@Test
	@DisplayName("testing a CSV file that does not exist")
	void testNoMessage() {
		assertThrows(IOException.class, ()->{
			testParser.parseFile("doesnotexist.txt");
		}, "exception was thrown for a non-existant CSV file");
	}
	
	@Test
	@DisplayName("test Insert 1 File")
	void test() throws SQLException, IOException{
		InfoForm form = testParser.parseFile("./src/test/java/group13/adam/parser/Test1User.csv");
		String url = "jdbc:sqlite:../icare-db/test.db";
        Connection conn = DriverManager.getConnection(url);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from InfoForum");
		for(String s: hm.getHeaderMap().keySet()){
			System.out.println(s);
			assertEquals(rs.getString(s), form.getInfoMap().get(hm.getHeaderMap().get(s)));
		}
        //assertEquals(rs.getString("unique_identifier"), "23-0300095");

	}
	
}
