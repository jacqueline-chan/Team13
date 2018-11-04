package group13.adam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class InsertFormDB {
 
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
    	// this db is malformed, giving errors
    	//String url = "jdbc:sqlite:../icare-db/test.db";
    	// testing this DB on my system
    	String url = "jdbc:sqlite:/home/jamie/Desktop/sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Insert a new row into the warehouses table
     *
     * @param fields from Application Form
     */
    public void insert(String[] fields) {
        String sql = "INSERT INTO InfoForum(unique_identifier,date_of_birth,postal_code,start_date_of_service,"
        		+ "language_of_service,official_language_of_preference,type_of_institution,referred_by,"
        		+ "services_received,total_length_of_orientation,total_length_of_orientation_hours,"
        		+ "total_length_of_orientation_minutes,number_of_clients_in_group,directed_at_a_specific,children,"
        		+ "youth,seniors,gender_specific,refugees,ethnic,deaf_or_hard_of_hearing,blind_or_partially_sighted,lgbtq,"
        		+ "families,clients_with_other_impairments,clients_with_international_training_in_a_regulated_profession,"
        		+ "clients_with_international_training_in_a_regulated_trade,official_language_minorities,"
        		+ "overview_of_canada,overview_of_canada_referrals,sources_of_information,"
        		+ "sources_of_information_referrals,rights_and_freedoms,rights_and_freedoms_referrals,"
        		+ "canadian_law_and_justice,important_documents,important_documents_referrals,"
        		+ "improving_english_or_french,improving_english_or_french_referrals,employment_and_income,"
        		+ "employment_and_income_referrals,education,education_referrals,housing,"
        		+ "housing_referrals,health,health_referrals,money_and_finances,money_and_finances_referrals,"
        		+ "transportation,transportation_referrals,communications_and_media,"
        		+ "communications_and_media_referrals,community_engagement,community_engagement_referrals,"
        		+ "becoming_a_canadian_citizen,becoming_a_canadian_citizen_referrals,interpersonal_conflict,"
        		+ "interpersonal_conflict_referrals,was_essential_skills_and_aptitude_training_received,"
        		+ "computer_skills,document_use,interpersonal_skills_and_workplace_culture,leadership_training,"
        		+ "numeracy,was_life_skills,life_skills,rights_and_responsibilities_of_citizenship,"
        		+ "support_services_received,care_for_newcomer_children,child_1_age,child_1_type_of_care,child_2_age,"
        		+ "child_2_type_of_care,child_3_age,child_3_type_of_care,child_4_age,child_4_type_of_care,child_5_age,"
        		+ "child_5_type_of_care,transportation_2,provisions_for_disabilities,translation,between_1,and_1,"
        		+ "interpretation,between_2,and_2,crisis_counselling,end_date_of_service,reason_for_update) "
        		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	for (int i = 0; i < fields.length; i++){
        		pstmt.setString(i+1, fields[i]);
        	}
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
}