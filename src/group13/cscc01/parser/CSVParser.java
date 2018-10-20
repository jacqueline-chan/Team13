package group13.cscc01.parser;

import com.opencsv.*;

import group13.cscc01.forms.InfoForm;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CSVParser {
	
	HashMap<String, String> headerMap = initializeHeaderMap();
	
	private final static String SAMPLE_CSV_FILE_PATH = "/home/jamie/Desktop/infoforum.csv";
    
    private HashMap<String, String> initializeHeaderMap() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("unique_identifier", "Unique Identifier");
        map.put("date_of_birth", "Date of Birth (YYYY-MM-DD)");
        map.put("postal_code", "Postal Code where the service was received");
        map.put("start_date_of_service", "Start Date of Service (YYYY-MM-DD)");
        map.put("language_of_service", "Language of Service");
        map.put("official_language_of_preference", "Official Language of Preference");
        map.put("type_of_institution", "Type of Institution/Organization Where Client Received Services");
        map.put("referred_by", "Referred By");
        map.put("services_received", "Services Received");
        map.put("total_length_of_orientation_hours", "Total Length of Orientation: Hours");
        map.put("total_length_of_orientation_minutes", "Total Length of Orientation: Minutes");
        map.put("number_of_clients_in_group","Number of Clients in Group");
        map.put("directed_at_a_specific", "Directed at a specific Target Group ");
        map.put("children", "Target Group: Children (0-14 yrs)");
        map.put("youth", "Target Group: Youth (15-24 yrs");
        map.put("seniors", "Target Group: Seniors");
        map.put("gender_specific", "Target Group: Gender-specific");
        map.put("refugees", "Target Group: Refugees");
        map.put("ethnic", "Target Group: Ethnic/cultural/linguistic group");
        map.put("deaf_or_hard_of_hearing", "Target Group: Deaf or Hard of Hearing");
        map.put("blind_or_partially_sighted", "Target Group: Blind or Partially Sighted");
        map.put("lgbtq", "Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)");
        map.put("families", "Target Group: Families/Parents");
        map.put("clients_with_other_impairments", "Target Group: Clients with other impairments (physical, mental)");
        map.put("clients_with_international_training_in_a_regulated_profession", "Target Group: Clients with international training in a regulated profession");
        map.put("clients_with_international_training_in_a_regulated_trade", "Target Group: Clients with international training in a regulated trade");
        map.put("official_language_minorities", "Target Group: Official Language minorities");
        map.put("overview_of_canada", "Overview of Canada");
        map.put("overview_of_canada_referrals", "Overview of Canada Referrals");
        map.put("sources_of_information", "Sources of Information");
        map.put("sources_of_information_referrals", "Sources of Information Referrals");
        map.put("rights_and_freedoms", "Rights and Freedoms");
        map.put("rights_and_freedoms_referrals", "Rights and Freedoms Referrals");
        map.put("canadian_law_and_justice", "Canadian Law and Justice");
        map.put("important_documents", "Important Documents");
        map.put("important_documents_referrals", "Important Documents Referrals");
        map.put("improving_english_or_french", "Improving English or French");
        map.put("improving_english_or_french_referrals", "Improving English or French Referrals");
        map.put("employment_and_income", "Employment and Income");
        map.put("employment_and_income_referrals", "Employment and Income Referrals");
        map.put("education", "Education");
        map.put("education_referrals", "Education Referrals");
        map.put("housing", "Housing");
        map.put("housing_referrals", "Housing Referrals");
        map.put("health", "Health");
        map.put("health_referrals", "Health Referrals");
        map.put("money_and_finances", "Money and Finances");
        map.put("money_and_finances_referrals", "Money and Finances Referrals");
        map.put("transportation", "Transportation");
        map.put("transportation_referrals", "Transportation Referrals");
        map.put("communications_and_media", "Communications and Media");
        map.put("communications_and_media_referrals", "Communications and Media Referrals");
        map.put("community_engagement", "Community Engagement");
        map.put("community_engagement_referrals", "Community Engagement Referrals");
        map.put("becoming_a_canadian_citizen", "Becoming a Canadian Citizen");
        map.put("becoming_a_canadian_citizen_referrals", "Becoming a Canadian Citizen Referrals");
        map.put("interpersonal_conflict", "Interpersonal Conflict");
        map.put("interpersonal_conflict_referrals", "Interpersonal Conflict Referrals");
        map.put("was_essential_skills_and_aptitude_training_received", "Was Essential Skills and Aptitude Training Received as Part of this Service?");
        map.put("computer_skills", "Computer skills");
        map.put("document_use", "Document Use");
        map.put("interpersonal_skills_and_workplace_culture", "Interpersonal Skills and Workplace Culture");
        map.put("leadership_training", "Leadership Training");
        map.put("numeracy", "Numeracy");
        map.put("was_life_skills", "Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?");
        map.put("life_skills", "Life Skills");
        map.put("rights_and_responsibilities_of_citizenship", "Rights and Responsibilities of Citizenship (based on discover Canada)");
        map.put("support_services_received", "Support Services Received");
        map.put("care_for_newcomer_children", "Care for Newcomer Children");
        map.put("child_1_age", "Child 1: Age");
        map.put("child_1_type_of_care", "Child 1: Type of Care");
        map.put("child_2_age", "Child 2: Age");
        map.put("child_2_type_of_care", "Child 2: Type of Care");
        map.put("child_3_age", "Child 3: Age");
        map.put("child_3_type_of_care", "Child 3: Type of Care");
        map.put("child_4_age", "Child 4: Age");
        map.put("child_4_type_of_care", "Child 4: Type of Care");
        map.put("child_5_age", "Child 5: Age");
        map.put("child_5_type_of_care", "Child 5: Type of Care");
        map.put("transportation_2", "Transportation 2");
        map.put("provisions_for_disabilities", "Provisions for Disabilities");
        map.put("translation", "Translation");
        map.put("between_1", "Between");
        map.put("and_1", "And");
        map.put("interpretation", "Interpretation");
        map.put("between_2", "Between 1");
        map.put("and_2", "And 2");
        map.put("crisis_counselling", "Crisis Counselling");
        map.put("end_date_of_service", "End Date of Service (YYYY-MM-DD)");
        map.put("reason_for_update", "Reason for update");
		
		return map;
	}

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
    
    
	public static void main(String[] args) throws IOException {
        CSVParser csv = new CSVParser();
        csv.parseFile(SAMPLE_CSV_FILE_PATH);
    }
}
