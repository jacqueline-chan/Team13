package group13.adam.parser;

import com.opencsv.*;

import group13.adam.db.InsertFormDB;
import group13.adam.gui.ApplicationForm;
import group13.adam.headermap.HeaderMap;
import group13.cscc01.forms.InfoForm;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class CSVParser {
	
	HeaderMap hm = new HeaderMap();
	
	HashMap<String, String> headerMap = hm.getHeaderMap();
	
	private final static String SAMPLECSVFILEPATH = "/home/jamie/Desktop/infoforum.csv";

	public void parseFile(String fileName) throws IOException{
		InsertFormDB db = new InsertFormDB();
		try {
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(fileName));
			CSVReader headerReader = new CSVReader(reader);
			String[] headers = headerReader.readNext();
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
	        String[] nextRecord;
	        while((nextRecord = csvReader.readNext()) != null){
	        	// insert into DB
	        	db.insert(nextRecord);
	        	//
	        	InfoForm form = new InfoForm();
	        	for (int i = 0; i < nextRecord.length; i++){
	        		form.updateInfoMap(headerMap.get(headers[i]), nextRecord[i]);
	        	}
	        	//printInfoMap(form);
	        }
	        csvReader.close();
	        headerReader.close();
		} catch (IOException e) {
			throw new IOException("Error parsing file: " + fileName);
		}


    }
	// print out the csv contents
    public void printInfoMap(InfoForm form){
    	System.out.println(form.getInfoMap());
    }
    
    /**
    public static void main(String[] args) throws IOException{
    	CSVParser test = new CSVParser();
    	test.parseFile("test.txt");
    }
    */
}
