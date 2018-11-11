package group13.cscc01.forms;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorForms {
  public static HashMap<String, Pattern> getOptionalParam() {
    HashMap<String, Pattern> regex = new HashMap<String, Pattern>();
    //regex.put("Total Length of Orientation",
    //    Pattern.compile("[0-9]* hours [0-9]* minutes"));
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
