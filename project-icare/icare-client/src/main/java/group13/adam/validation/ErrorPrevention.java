package group13.adam.validation;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;

import group13.adam.gui.ApplicationForm;
import group13.cscc01.forms.*;
public class ErrorPrevention {
	private HashMap<String, String> mandatoryFields;
	private HashMap<String, String> optionalFields;
	public ErrorPrevention(FormManager fm) {
	  mandatoryFields = fm.getMandFields();
	  optionalFields = fm.getOptFields();
	}
	  public int CheckIfFieldsAreValid(String [] fieldNames, JFormattedTextField[] fields) {
        /*for (int i = 0; i < fieldNames.length; i++) {
          if (mandatoryFields.containsKey(fieldNames[i])) {
            System.out.println("Mandatory: "+fieldNames[i]+" "+mandatoryFields.get(fieldNames[i]));
          } else {
            System.out.println("Optional: "+fieldNames[i]+" "+optionalFields.get(fieldNames[i]));
          }
        }*/
	        int i = 0;
		    boolean noMistakes = true;
		    boolean isOptional;
		    Matcher m;
		    Matcher empty;
		    while ((i < fieldNames.length) && (noMistakes)) {
		         empty = Pattern.compile("").matcher(fields[i].getText());
		        isOptional = false;
		        if(optionalFields.containsKey(fieldNames[i])) {
		          m = Pattern.compile(optionalFields.get(fieldNames[i])).matcher(fields[i].getText());
		          isOptional = true;
		        } else {
		          m = Pattern.compile(mandatoryFields.get(fieldNames[i])).matcher(fields[i].getText());
		        }
		        if((m.matches()) ||(isOptional && empty.matches())) {
                  i++;
		        }
		        else {
		          noMistakes = false;

		        }
		    }
		    if (noMistakes) {
		      return -1;
		    } else {
		      return i;
		    }
		  }

}
