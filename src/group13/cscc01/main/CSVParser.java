package group13.cscc01.main;

import com.opencsv.*;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CSVParser {
	private static final String SAMPLE_CSV_FILE_PATH = "/home/jamie/Desktop/iCARE_template.csv";
    public static void main(String[] args) throws IOException {
        System.out.println("Hello CSV");
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(5).build();
            ) {
                // Reading Records One by One in a String array
                String[] nextRecord;
                String[] nextnextRecord;
                nextRecord = csvReader.readNext();
                nextnextRecord = csvReader.readNext();
                HashMap<String, String> test = new LinkedHashMap<>();
                for (int i = 0; i < nextRecord.length; i++){
                	test.put(nextRecord[i], nextnextRecord[i]);
                }
                System.out.println(test);
        
        	}

    }
}
