package group13.adam.parser;

import com.opencsv.*;

import group13.adam.headermap.HeaderMap;
import group13.cscc01.forms.InfoForm;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CSVParser {
	
	HeaderMap hm = new HeaderMap();
	
	HashMap<String, String> headerMap = hm.getHeaderMap();
	
	private final static String SAMPLE_CSV_FILE_PATH = "/home/jamie/Desktop/infoforum.csv";

	public void parseFile(String fileName){
		try {
			Reader reader;
			reader = Files.newBufferedReader(Paths.get(fileName));
			CSVReader headerReader = new CSVReader(reader);
			String[] headers = headerReader.readNext();
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
	        String[] nextRecord;
	        while((nextRecord = csvReader.readNext()) != null){
	        	InfoForm form = new InfoForm();
	        	for (int i = 0; i < nextRecord.length; i++){
	        		form.updateInfoMap(headerMap.get(headers[i]), nextRecord[i]);
	        	}
	        	submitToDB(form);
	        }
	        csvReader.close();
	        headerReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
    
    public void submitToDB(InfoForm form){
    	System.out.println(form.getInfoMap());
    }
}
