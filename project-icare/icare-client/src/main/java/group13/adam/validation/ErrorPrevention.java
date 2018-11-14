package group13.adam.validation;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;

import group13.adam.gui.ApplicationForm;
import group13.cscc01.forms.*;
public class ErrorPrevention {
	
	  public int CheckIfFieldsAreValid(String [] fieldNames, JFormattedTextField[] fields) {
		    HashMap<String, Pattern> mandatoryFields = ErrorForms.getCompulsoryParam();
		    HashMap<String, Pattern> optionalFields = ErrorForms.getOptionalParam();
		    int i = 0;
		    boolean noMistakes = true;
		    boolean isOptional;
		    Matcher m;
		    Matcher empty;
		    while ((i < fieldNames.length) && (noMistakes)) {
		         empty = Pattern.compile("").matcher(fields[i].getText());
		        isOptional = false;
		        if(optionalFields.containsKey(fieldNames[i])) {
		          m = optionalFields.get(fieldNames[i]).matcher(fields[i].getText());
		          isOptional = true;
		        } else {
		          m = mandatoryFields.get(fieldNames[i]).matcher(fields[i].getText());
		        }
		        if((m.matches()) ||(isOptional && empty.matches())) {
                  i++;
		        }
		        else {
		          // System.out.println(fieldNames[i]);
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
