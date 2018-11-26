package group13.adam.gui.components;

import java.awt.Font;

import javax.swing.JLabel;

public class Strings {
	
	public String[] headerstring(){
		String[] fieldNames = new String[] {"Unique Identifier",
			      "Date of Birth (YYYY-MM-DD)",
			      "Postal Code where the service was received",
			      "Start Date of Service (YYYY-MM-DD)", "Language of Service",
			      "Official Language of Preference",
			      "Type of Institution/Organization Where Client Received Services",
			      "Referred By", "Services Received",
			      "Total Length of Orientation: Hours",
			      "Total Length of Orientation: Minutes", "Number of Clients in Group",
			      "Directed at a specific Target Group ",
			      "Target Group: Children (0-14 yrs)", "Target Group: Youth (15-24 yrs",
			      "Target Group: Seniors", "Target Group: Gender-specific",
			      "Target Group: Refugees",
			      "Target Group: Ethnic/cultural/linguistic group",
			      "Target Group: Deaf or Hard of Hearing",
			      "Target Group: Blind or Partially Sighted",
			      "Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)",
			      "Target Group: Families/Parents",
			      "Target Group: Clients with other impairments (physical, mental)",
			      "Target Group: Clients with international training in a regulated profession",
			      "Target Group: Clients with international training in a regulated trade",
			      "Target Group: Official Language minorities", "Overview of Canada",
			      "Overview of Canada Referrals", "Sources of Information",
			      "Sources of Information Referrals", "Rights and Freedoms",
			      "Rights and Freedoms Referrals", "Canadian Law and Justice",
			      "Important Documents", "Important Documents Referrals",
			      "Improving English or French", "Improving English or French Referrals",
			      "Employment and Income", "Employment and Income Referrals", "Education",
			      "Education Referrals", "Housing", "Housing Referrals", "Health",
			      "Health Referrals", "Money and Finances", "Money and Finances Referrals",
			      "Transportation", "Transportation Referrals", "Communications and Media",
			      "Communications and Media Referrals", "Community Engagement",
			      "Community Engagement Referrals", "Becoming a Canadian Citizen",
			      "Becoming a Canadian Citizen Referrals", "Interpersonal Conflict",
			      "Interpersonal Conflict Referrals",
			      "Was Essential Skills and Aptitude Training Received as Part of this Service?",
			      "Computer skills", "Document Use",
			      "Interpersonal Skills and Workplace Culture", "Leadership Training",
			      "Numeracy",
			      "Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?",
			      "Life Skills",
			      "Rights and Responsibilities of Citizenship (based on discover Canada)",
			      "Support Services Received", "Care for Newcomer Children", "Child 1: Age",
			      "Child 1: Type of Care", "Child 2: Age", "Child 2: Type of Care",
			      "Child 3: Age", "Child 3: Type of Care", "Child 4: Age",
			      "Child 4: Type of Care", "Child 5: Age", "Child 5: Type of Care",
			      "Transportation 2", "Provisions for Disabilities", "Translation",
			      "Between", "And", "Interpretation", "Between 1", "And 2",
			      "Crisis Counselling", "End Date of Service (YYYY-MM-DD)",
			      "Reason for update"};
		return fieldNames;
	}
	
	public void setfondBold(JLabel[] labels){
		labels[0].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // unique identifier
		labels[1].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // birthdate
		labels[2].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // postalcode
		labels[3].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // startdate
		labels[4].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // language
		labels[5].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // official language
		labels[6].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // type of orgainization
		labels[7].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // referred by
		labels[8].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // services received
		labels[58].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // was essential skills recieved
		labels[64].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // was lifeskills recieved
		labels[67].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // was support services recieved
		labels[88].setFont(labels[0].getFont().deriveFont(Font.BOLD, 14f)); // was lifeskills recieved
	}

}
