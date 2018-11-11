package group13.adam.parser;

import com.opencsv.*;

import group13.adam.db.InsertFormDB;
import group13.adam.headermap.HeaderMap;
import group13.cscc01.forms.InfoForm;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;

public class CSVParser {
	
	HeaderMap hm = new HeaderMap();
	
	HashMap<String, String> headerMap = hm.getHeaderMap();
	
	//private final static String SAMPLECSVFILEPATH = "/home/jamie/Desktop/infoforum.csv";

	public InfoForm parseFile(String fileName) throws IOException, SQLException{
		InsertFormDB db = new InsertFormDB();
    	InfoForm form = new InfoForm();
    	
		try {
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(fileName));
			CSVReader headerReader = new CSVReader(reader);
			String[] headers = headerReader.readNext();
			CSVReader csvReader = new CSVReaderBuilder(reader).build();
	        String[] nextRecord;
	        while((nextRecord = csvReader.readNext()) != null){
	        	// insert into DB
	        	db.insert(nextRecord);
	        	//
	        	for (int i = 0; i < nextRecord.length; i++){
	        		form.updateInfoMap(headerMap.get(headers[i]), nextRecord[i]);
	        	}
	        }
	        csvReader.close();
	        headerReader.close();
		} catch (IOException e) {
			throw new IOException("Error parsing file: " + fileName);
		}
		
		return form;
    }
    
    
}
