package group13.cscc01.forms;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorForms {
  public static HashMap<String, Pattern> getOptionalParam() {
    HashMap<String, Pattern> regex = new HashMap<String, Pattern>();
    /*regex.put(Pattern.compile("[0-9]* hours [0-9]* minutes"), new String[]
        {"of the following format: \"number\" hours \"number\" minutes",
            "Total Length of Orientation"});
    regex.put(Pattern.compile("[0-9]*"), new String[] {"a number", "Total Length of Orientation: Hours",
        "Total Length of Orientation: Minutes", "Number of Clients in Group"});
    regex.put(Pattern.compile("(Yes)|(No)"), new String[] {"Yes or No",
        "Directed at a specific Target Group ", "Target Group: Children (0-14 yrs)",
        "Target Group: Youth (15-24 yrs", "Target Group: Seniors", "Target Group: Gender-specific", 
        "Target Group: Refugees", "Target Group: Ethnic/cultural/linguistic group",
        "Target Group: Deaf or Hard of Hearing", "Target Group: Blind or Partially Sighted",
        "Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)",
        "Target Group: Families/Parents", "Target Group: Clients with other impairments (physical, mental)",
        "Target Group: Clients with international training in a regulated profession",
        "Target Group: Families/Parents", "Target Group: Clients with other impairments (physical, mental)",
        "Target Group: Clients with international training in a regulated trade",
        "Target Group: Official Language minorities", "Care for Newcomer Children"});
    regex.put(Pattern.compile(".+"), new String[] {"Any character", "Overview of Canada",
        "Overview of Canada Referrals","Sources of Information",
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
        "Computer skills", "Document Use",
        "Interpersonal Skills and Workplace Culture", "Leadership Training",
        "Numeracy",
        "Life Skills",
        "Rights and Responsibilities of Citizenship (based on discover Canada)",
        "Transportation 2", "Provisions for Disabilities",
        "Translation", "Between", "And", "Interpretation", "Between 1", "And 2",
        "Crisis Counselling","Child 1: Type of Care", "Child 2: Type of Care",
        "Child 3: Type of Care", "Child 4: Type of Care", 
        "Child 5: Type of Care", "Reason for update"});
    regex.put(Pattern.compile("[0-9]{1,2}"), new String[] {"Child 1: Age",
        "Child 2: Age", 
        "Child 3: Age", "Child 4: Age",
        "Child 5: Age"});*/
    regex.put("Total Length of Orientation",
        Pattern.compile("[0-9]* hours [0-9]* minutes"));
    regex.put("Total Length of Orientation: Hours", Pattern.compile("[0-9]*"));
    regex.put("Total Length of Orientation: Minutes",
        Pattern.compile("[0-9]*"));
    regex.put("Number of Clients in Group", Pattern.compile("[0-9]*"));
    regex.put("Directed at a specific Target Group ",
        Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Children (0-14 yrs)",
        Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Youth (15-24 yrs", Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Seniors", Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Gender-specific", Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Refugees", Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Ethnic/cultural/linguistic group",
        Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Deaf or Hard of Hearing",
        Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Blind or Partially Sighted",
        Pattern.compile("(Yes)|(No)"));
    regex.put(
        "Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)",
        Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Families/Parents", Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Clients with other impairments (physical, mental)",
        Pattern.compile("(Yes)|(No)"));
    regex.put(
        "Target Group: Clients with international training in a regulated profession",
        Pattern.compile("(Yes)|(No)"));
    regex.put(
        "Target Group: Clients with international training in a regulated trade",
        Pattern.compile("(Yes)|(No)"));
    regex.put("Target Group: Official Language minorities",
        Pattern.compile("(Yes)|(No)"));
    regex.put("Overview of Canada", Pattern.compile(".+"));
    regex.put("Overview of Canada Referrals", Pattern.compile(".+"));
    regex.put("Sources of Information", Pattern.compile(".+"));
    regex.put("Sources of Information Referrals", Pattern.compile(".+"));
    regex.put("Rights and Freedoms", Pattern.compile(".+"));
    regex.put("Rights and Freedoms Referrals", Pattern.compile(".+"));
    regex.put("Canadian Law and Justice", Pattern.compile(".+"));
    regex.put("Important Documents", Pattern.compile(".+"));
    regex.put("Important Documents Referrals", Pattern.compile(".+"));
    regex.put("Improving English or French", Pattern.compile(".+"));
    regex.put("Improving English or French Referrals", Pattern.compile(".+"));
    regex.put("Employment and Income", Pattern.compile(".+"));
    regex.put("Employment and Income Referrals", Pattern.compile(".+"));
    regex.put("Education", Pattern.compile(".+"));
    regex.put("Education Referrals", Pattern.compile(".+"));
    regex.put("Housing", Pattern.compile(".+"));
    regex.put("Housing Referrals", Pattern.compile(".+"));
    regex.put("Health", Pattern.compile(".+"));
    regex.put("Health Referrals", Pattern.compile(".+"));
    regex.put("Money and Finances", Pattern.compile(".+"));
    regex.put("Money and Finances Referrals", Pattern.compile(".+"));
    regex.put("Transportation", Pattern.compile(".+"));
    regex.put("Transportation Referrals", Pattern.compile(".+"));
    regex.put("Communications and Media", Pattern.compile(".+"));
    regex.put("Communications and Media Referrals", Pattern.compile(".+"));
    regex.put("Community Engagement", Pattern.compile(".+"));
    regex.put("Community Engagement Referrals", Pattern.compile(".+"));
    regex.put("Becoming a Canadian Citizen", Pattern.compile(".+"));
    regex.put("Becoming a Canadian Citizen Referrals", Pattern.compile(".+"));
    regex.put("Interpersonal Conflict", Pattern.compile(".+"));
    regex.put("Interpersonal Conflict Referrals", Pattern.compile(".+"));
    regex.put("Computer skills", Pattern.compile(".+"));
    regex.put("Document Use", Pattern.compile(".+"));
    regex.put("Interpersonal Skills and Workplace Culture",
        Pattern.compile(".+"));
    regex.put("Leadership Training", Pattern.compile(".+"));
    regex.put("Numeracy", Pattern.compile(".+"));
    regex.put("Life Skills", Pattern.compile(".+"));
    regex.put(
        "Rights and Responsibilities of Citizenship (based on discover Canada)",
        Pattern.compile(".+"));
    regex.put("Care for Newcomer Children", Pattern.compile("(Yes)|(No)"));
    regex.put("Child 1: Age", Pattern.compile("[0-9]{1,2}"));
    regex.put("Child 1: Type of Care", Pattern.compile(".*"));
    regex.put("Child 2: Age", Pattern.compile("[0-9]{1,2}"));
    regex.put("Child 2: Type of Care", Pattern.compile(".*"));
    regex.put("Child 3: Age", Pattern.compile("[0-9]{1,2}"));
    regex.put("Child 3: Type of Care", Pattern.compile(".*"));
    regex.put("Child 4: Age", Pattern.compile("[0-9]{1,2}"));
    regex.put("Child 4: Type of Care", Pattern.compile(".*"));
    regex.put("Child 5: Age", Pattern.compile("[0-9]{1,2}"));
    regex.put("Child 5: Type of Care", Pattern.compile(".*"));
    regex.put("Transportation 2", Pattern.compile(".*"));
    regex.put("Provisions for Disabilities", Pattern.compile(".*"));
    regex.put("Translation", Pattern.compile(".*"));
    regex.put("Between", Pattern.compile(".*"));
    regex.put("And", Pattern.compile(".*"));
    regex.put("Interpretation", Pattern.compile(".*"));
    regex.put("Between 1", Pattern.compile(".*"));
    regex.put("And 2", Pattern.compile(".*"));
    regex.put("Crisis Counselling", Pattern.compile(".*"));
    regex.put("Reason for update", Pattern.compile(".*"));
    return regex;
  }

  public static HashMap<String, Pattern> getCompulsoryParam() {
    HashMap<String, Pattern> regex = new HashMap<String, Pattern>();
    /*regex.put(Pattern.compile("\\d*"), new String[] {"a number","Unique Identifier"});
    regex.put(Pattern.compile("(19|20)[0-9]{2}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))"),
        new String[] {"YYYY-MM-DD", "Date of Birth (YYYY-MM-DD)", "Start Date of Service (YYYY-MM-DD)",
            "End Date of Service (YYYY-MM-DD)"});
    regex.put(Pattern.compile("([A-Z][0-9]){3}"), new String[] {"of the form LetterNumberLetterNumberLetterNumber",
        "Postal Code where the service was received"});
    regex.put(Pattern.compile("[(A-Z)|(a-z)]+"), new String[] {"any letters", "Language of Service",
        "Official Language of Preference"});
    regex.put(Pattern.compile("[(A-Z)|(a-z)| ]+"), new String[] {"letters and spaces",
        "Type of Institution/Organization Where Client Received Services",
        "Referred By", "Services Received"});
    regex.put(Pattern.compile("(Yes)|(No)"), new String[] {"Yes or No",
        "Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?",
        "Was Essential Skills and Aptitude Training Received as Part of this Service?",
        "Support Services Received"});*/
    regex.put("Unique Identifier", Pattern.compile("\\d+"));
    regex.put("Date of Birth (YYYY-MM-DD)", Pattern.compile(
        "(19|20)[0-9]{2}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))"));
    regex.put("Postal Code where the service was received",
        Pattern.compile("([A-Z][0-9]){3}"));
    regex.put("Start Date of Service (YYYY-MM-DD)", Pattern.compile(
        "(19|20)[0-9]{2}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))"));
    regex.put("Language of Service", Pattern.compile("[(A-Z)|(a-z)]+"));
    regex.put("Official Language of Preference",
        Pattern.compile("[(A-Z)|(a-z)]+"));
    regex.put("Type of Institution/Organization Where Client Received Services",
        Pattern.compile("[(A-Z)|(a-z)| ]+"));
    regex.put("Referred By", Pattern.compile("[(A-Z)|(a-z)| ]+"));
    regex.put("Services Received", Pattern.compile("[(A-Z)|(a-z)| ]+"));
    regex.put(
        "Was Essential Skills and Aptitude Training Received as Part of this Service?",
        Pattern.compile("(Yes)|(No)"));
    regex.put(
        "Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?",
        Pattern.compile("(Yes)|(No)"));
    regex.put("Support Services Received", Pattern.compile("(Yes)|(No)"));
    regex.put("End Date of Service (YYYY-MM-DD)", Pattern.compile(
        "(19|20)[0-9]{2}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))"));
    return regex;
  }
}
