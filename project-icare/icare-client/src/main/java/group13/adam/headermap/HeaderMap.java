package group13.adam.headermap;

import java.util.HashMap;

public class HeaderMap {
	
	private HashMap<String, String> map;
	
    public HeaderMap(){
		initializeHeaderMap();
	}
    
    private void initializeHeaderMap(){
		this.map.put("unique_identifier", "Unique Identifier");
        this.map.put("date_of_birth", "Date of Birth (YYYY-MM-DD)");
        this.map.put("postal_code", "Postal Code where the service was received");
        this.map.put("start_date_of_service", "Start Date of Service (YYYY-MM-DD)");
        this.map.put("language_of_service", "Language of Service");
        this.map.put("official_language_of_preference", "Official Language of Preference");
        this.map.put("type_of_institution", "Type of Institution/Organization Where Client Received Services");
        this.map.put("referred_by", "Referred By");
        this.map.put("services_received", "Services Received");
        this.map.put("total_length_of_orientation_hours", "Total Length of Orientation: Hours");
        this.map.put("total_length_of_orientation_minutes", "Total Length of Orientation: Minutes");
        this.map.put("number_of_clients_in_group","Number of Clients in Group");
        this.map.put("directed_at_a_specific", "Directed at a specific Target Group ");
        this.map.put("children", "Target Group: Children (0-14 yrs)");
        this.map.put("youth", "Target Group: Youth (15-24 yrs");
        this.map.put("seniors", "Target Group: Seniors");
        this.map.put("gender_specific", "Target Group: Gender-specific");
        this.map.put("refugees", "Target Group: Refugees");
        this.map.put("ethnic", "Target Group: Ethnic/cultural/linguistic group");
        this.map.put("deaf_or_hard_of_hearing", "Target Group: Deaf or Hard of Hearing");
        this.map.put("blind_or_partially_sighted", "Target Group: Blind or Partially Sighted");
        this.map.put("lgbtq", "Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)");
        this.map.put("families", "Target Group: Families/Parents");
        this.map.put("clients_with_other_impairments", "Target Group: Clients with other impairments (physical, mental)");
        this.map.put("clients_with_international_training_in_a_regulated_profession", "Target Group: Clients with international training in a regulated profession");
        this.map.put("clients_with_international_training_in_a_regulated_trade", "Target Group: Clients with international training in a regulated trade");
        this.map.put("official_language_minorities", "Target Group: Official Language minorities");
        this.map.put("overview_of_canada", "Overview of Canada");
        this.map.put("overview_of_canada_referrals", "Overview of Canada Referrals");
        this.map.put("sources_of_information", "Sources of Information");
        this.map.put("sources_of_information_referrals", "Sources of Information Referrals");
        this.map.put("rights_and_freedoms", "Rights and Freedoms");
        this.map.put("rights_and_freedoms_referrals", "Rights and Freedoms Referrals");
        this.map.put("canadian_law_and_justice", "Canadian Law and Justice");
        this.map.put("important_documents", "Important Documents");
        this.map.put("important_documents_referrals", "Important Documents Referrals");
        this.map.put("improving_english_or_french", "Improving English or French");
        this.map.put("improving_english_or_french_referrals", "Improving English or French Referrals");
        this.map.put("employment_and_income", "Employment and Income");
        this.map.put("employment_and_income_referrals", "Employment and Income Referrals");
        this.map.put("education", "Education");
        this.map.put("education_referrals", "Education Referrals");
        this.map.put("housing", "Housing");
        this.map.put("housing_referrals", "Housing Referrals");
        this.map.put("health", "Health");
        this.map.put("health_referrals", "Health Referrals");
        this.map.put("money_and_finances", "Money and Finances");
        this.map.put("money_and_finances_referrals", "Money and Finances Referrals");
        this.map.put("transportation", "Transportation");
        this.map.put("transportation_referrals", "Transportation Referrals");
        this.map.put("communications_and_media", "Communications and Media");
        this.map.put("communications_and_media_referrals", "Communications and Media Referrals");
        this.map.put("community_engagement", "Community Engagement");
        this.map.put("community_engagement_referrals", "Community Engagement Referrals");
        this.map.put("becoming_a_canadian_citizen", "Becoming a Canadian Citizen");
        this.map.put("becoming_a_canadian_citizen_referrals", "Becoming a Canadian Citizen Referrals");
        this.map.put("interpersonal_conflict", "Interpersonal Conflict");
        this.map.put("interpersonal_conflict_referrals", "Interpersonal Conflict Referrals");
        this.map.put("was_essential_skills_and_aptitude_training_received", "Was Essential Skills and Aptitude Training Received as Part of this Service?");
        this.map.put("computer_skills", "Computer skills");
        this.map.put("document_use", "Document Use");
        this.map.put("interpersonal_skills_and_workplace_culture", "Interpersonal Skills and Workplace Culture");
        this.map.put("leadership_training", "Leadership Training");
        this.map.put("numeracy", "Numeracy");
        this.map.put("was_life_skills", "Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?");
        this.map.put("life_skills", "Life Skills");
        this.map.put("rights_and_responsibilities_of_citizenship", "Rights and Responsibilities of Citizenship (based on discover Canada)");
        this.map.put("support_services_received", "Support Services Received");
        this.map.put("care_for_newcomer_children", "Care for Newcomer Children");
        this.map.put("child_1_age", "Child 1: Age");
        this.map.put("child_1_type_of_care", "Child 1: Type of Care");
        this.map.put("child_2_age", "Child 2: Age");
        this.map.put("child_2_type_of_care", "Child 2: Type of Care");
        this.map.put("child_3_age", "Child 3: Age");
        this.map.put("child_3_type_of_care", "Child 3: Type of Care");
        this.map.put("child_4_age", "Child 4: Age");
        this.map.put("child_4_type_of_care", "Child 4: Type of Care");
        this.map.put("child_5_age", "Child 5: Age");
        this.map.put("child_5_type_of_care", "Child 5: Type of Care");
        this.map.put("transportation_2", "Transportation 2");
        this.map.put("provisions_for_disabilities", "Provisions for Disabilities");
        this.map.put("translation", "Translation");
        this.map.put("between_1", "Between");
        this.map.put("and_1", "And");
        this.map.put("interpretation", "Interpretation");
        this.map.put("between_2", "Between 1");
        this.map.put("and_2", "And 2");
        this.map.put("crisis_counselling", "Crisis Counselling");
        this.map.put("end_date_of_service", "End Date of Service (YYYY-MM-DD)");
        this.map.put("reason_for_update", "Reason for update");
    }
    
    public HashMap<String, String> getHeaderMap(){
    	return this.map;
    }
}
