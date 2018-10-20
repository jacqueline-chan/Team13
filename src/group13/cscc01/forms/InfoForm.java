package group13.cscc01.forms;

import java.util.LinkedHashMap;
import java.util.Map;

public class InfoForm {
    protected Map<String, String> infoMap;


    public Map<String, String> getInfoMap() {
        return infoMap;
    }

    public boolean updateInfoMap(String key, String value) {
        if (this.infoMap.containsKey(key)){
            this.infoMap.put(key, value);
            return true;
        }
        return false;
    }

    public InfoForm() {
    	infoMap = new LinkedHashMap<String, String>();
        this.infoMap.put("Unique Identifier", "");
        this.infoMap.put("Date of Birth (YYYY-MM-DD)", "");
        this.infoMap.put("Postal Code where the service was received", "");
        this.infoMap.put("Start Date of Service (YYYY-MM-DD)", "");
        this.infoMap.put("Language of Service", "");
        this.infoMap.put("Official Language of Preference", "");
        this.infoMap.put("Type of Institution/Organization Where Client Received Services", "");
        this.infoMap.put("Referred By", "");
        this.infoMap.put("Services Received", "");
        this.infoMap.put("Total Length of Orientation", "");
        this.infoMap.put("Total Length of Orientation: Hours", "");
        this.infoMap.put("Total Length of Orientation: Minutes", "");
        this.infoMap.put("Number of Clients in Group", "");
        this.infoMap.put("Directed at a specific Target Group ", "");
        this.infoMap.put("Target Group: Children (0-14 yrs)", "");
        this.infoMap.put("Target Group: Youth (15-24 yrs", "");
        this.infoMap.put("Target Group: Seniors", "");
        this.infoMap.put("Target Group: Gender-specific", "");
        this.infoMap.put("Target Group: Refugees", "");
        this.infoMap.put("Target Group: Ethnic/cultural/linguistic group", "");
        this.infoMap.put("Target Group: Deaf or Hard of Hearing", "");
        this.infoMap.put("Target Group: Blind or Partially Sighted", "");
        this.infoMap.put("Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)", "");
        this.infoMap.put("Target Group: Families/Parents", "");
        this.infoMap.put("Target Group: Clients with other impairments (physical, mental)", "");
        this.infoMap.put("Target Group: Clients with international training in a regulated profession", "");
        this.infoMap.put("Target Group: Clients with international training in a regulated trade", "");
        this.infoMap.put("Target Group: Official Language minorities", "");
        this.infoMap.put("Overview of Canada", "");
        this.infoMap.put("Overview of Canada Referrals", "");
        this.infoMap.put("Sources of Information", "");
        this.infoMap.put("Sources of Information Referrals", "");
        this.infoMap.put("Rights and Freedoms", "");
        this.infoMap.put("Rights and Freedoms Referrals", "");
        this.infoMap.put("Canadian Law and Justice", "");
        this.infoMap.put("Important Documents", "");
        this.infoMap.put("Important Documents Referrals", "");
        this.infoMap.put("Improving English or French", "");
        this.infoMap.put("Improving English or French Referrals", "");
        this.infoMap.put("Employment and Income", "");
        this.infoMap.put("Employment and Income Referrals", "");
        this.infoMap.put("Education", "");
        this.infoMap.put("Education Referrals", "");
        this.infoMap.put("Housing", "");
        this.infoMap.put("Housing Referrals", "");
        this.infoMap.put("Health", "");
        this.infoMap.put("Health Referrals", "");
        this.infoMap.put("Money and Finances", "");
        this.infoMap.put("Money and Finances Referrals", "");
        this.infoMap.put("Transportation", "");
        this.infoMap.put("Transportation Referrals", "");
        this.infoMap.put("Communications and Media", "");
        this.infoMap.put("Communications and Media Referrals", "");
        this.infoMap.put("Community Engagement", "");
        this.infoMap.put("Community Engagement Referrals", "");
        this.infoMap.put("Becoming a Canadian Citizen", "");
        this.infoMap.put("Becoming a Canadian Citizen Referrals", "");
        this.infoMap.put("Interpersonal Conflict", "");
        this.infoMap.put("Interpersonal Conflict Referrals", "");
        this.infoMap.put("Was Essential Skills and Aptitude Training Received as Part of this Service?", "");
        this.infoMap.put("Computer skills", "");
        this.infoMap.put("Document Use", "");
        this.infoMap.put("Interpersonal Skills and Workplace Culture", "");
        this.infoMap.put("Leadership Training", "");
        this.infoMap.put("Numeracy", "");
        this.infoMap
                .put("Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?",
                        "");
        this.infoMap.put("Life Skills", "");
        this.infoMap.put("Rights and Responsibilities of Citizenship (based on discover Canada)", "");
        this.infoMap.put("Support Services Received", "");
        this.infoMap.put("Care for Newcomer Children", "");
        this.infoMap.put("Child 1: Age", "");
        this.infoMap.put("Child 1: Type of Care", "");
        this.infoMap.put("Child 2: Age", "");
        this.infoMap.put("Child 2: Type of Care", "");
        this.infoMap.put("Child 3: Age", "");
        this.infoMap.put("Child 3: Type of Care", "");
        this.infoMap.put("Child 4: Age", "");
        this.infoMap.put("Child 4: Type of Care", "");
        this.infoMap.put("Child 5: Age", "");
        this.infoMap.put("Child 5: Type of Care", "");
        this.infoMap.put("Transportation 2", "");
        this.infoMap.put("Provisions for Disabilities", "");
        this.infoMap.put("Translation", "");
        this.infoMap.put("Between", "");
        this.infoMap.put("And", "");
        this.infoMap.put("Interpretation", "");
        this.infoMap.put("Between 1", "");
        this.infoMap.put("And 2", "");
        this.infoMap.put("Crisis Counselling", "");
        this.infoMap.put("End Date of Service (YYYY-MM-DD)", "");
        this.infoMap.put("Reason for update", "");
    }
}
