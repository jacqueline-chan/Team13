package group13.adam.parser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CSVParserTest {

	CSVParser testParser = new CSVParser();
	
	@Test
	@DisplayName("Testing for incorrect filename")
	void testIncorrectFileName() {
		try{
			testParser.parseFile("doesnotexist.txt");
			fail("Did not throw an exception for bad filename");
		}
		catch(IOException e){
			// pass
		}
	}
	
}
