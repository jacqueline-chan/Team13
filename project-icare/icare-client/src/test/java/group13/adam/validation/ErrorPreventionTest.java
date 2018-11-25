package group13.adam.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import group13.adam.gui.ApplicationForm;


import javax.swing.JFormattedTextField;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorPreventionTest {
	ErrorPrevention testError = new ErrorPrevention();
	ApplicationForm testForm = new ApplicationForm();
	
	@Test
	@DisplayName("Testing input with all fields filled in with appropriate values")
	void testGoodInput(){
		JFormattedTextField[] fields = new JFormattedTextField[100];
		for (int i = 0; i < fields.length; i++)
			fields[i] = new JFormattedTextField();
		fields[0].setValue("000");
		fields[1].setValue("1997-11-18");
		fields[2].setValue("L3R1A1");
		fields[3].setValue("1997-11-18");
		fields[4].setValue("English");
		fields[5].setValue("English");
		fields[6].setValue("Hospital");
		fields[7].setValue("Advertisement");
		fields[8].setValue("Job Help");
		fields[9].setValue("8");
		fields[10].setValue("30");
		fields[11].setValue("5");
		fields[12].setValue("Yes");
		fields[13].setValue("Yes");
		fields[14].setValue("Yes");
		fields[15].setValue("Yes");
		fields[16].setValue("Yes");
		fields[17].setValue("Yes");
		fields[18].setValue("Yes");
		fields[19].setValue("Yes");
		fields[20].setValue("Yes");
		fields[21].setValue("Yes");
		fields[22].setValue("Yes");
		fields[23].setValue("Yes");
		fields[24].setValue("Yes");
		fields[25].setValue("Yes");
		fields[26].setValue("Yes");
		fields[27].setValue("test");
		fields[28].setValue("test");
		fields[29].setValue("test");
		fields[30].setValue("test");
		fields[31].setValue("test");
		fields[32].setValue("test");
		fields[33].setValue("test");
		fields[34].setValue("test");
		fields[35].setValue("test");
		fields[36].setValue("test");
		fields[37].setValue("test");
		fields[38].setValue("test");
		fields[39].setValue("test");
		fields[40].setValue("test");
		fields[41].setValue("test");
		fields[42].setValue("test");
		fields[43].setValue("test");
		fields[44].setValue("test");
		fields[45].setValue("test");
		fields[46].setValue("test");
		fields[47].setValue("test");
		fields[48].setValue("test");
		fields[49].setValue("test");
		fields[50].setValue("test");
		fields[51].setValue("test");
		fields[52].setValue("test");
		fields[53].setValue("test");
		fields[54].setValue("test");
		fields[55].setValue("test");
		fields[56].setValue("test");
		fields[57].setValue("test");
		fields[58].setValue("Yes");
		fields[59].setValue("test");
		fields[60].setValue("test");
		fields[61].setValue("test");
		fields[62].setValue("test");
		fields[63].setValue("test");
		fields[64].setValue("Yes");
		fields[65].setValue("test");
		fields[66].setValue("test");
		fields[67].setValue("Yes");
		fields[68].setValue("Yes");
		fields[69].setValue("5");
		fields[70].setValue("5");
		fields[71].setValue("5");
		fields[72].setValue("5");
		fields[73].setValue("5");
		fields[74].setValue("5");
		fields[75].setValue("5");
		fields[76].setValue("5");
		fields[77].setValue("5");
		fields[78].setValue("5");
		fields[79].setValue("test");
		fields[80].setValue("test");
		fields[81].setValue("test");
		fields[82].setValue("test");
		fields[83].setValue("test");
		fields[84].setValue("test");
		fields[85].setValue("test");
		fields[86].setValue("test");
		fields[87].setValue("test");
		fields[88].setValue("1997-11-18");
		fields[89].setValue("test");
		int result;
		result = testError.CheckIfFieldsAreValid(testForm.getfieldNames(), fields);
		assertEquals(result, -1);
	}
	
	@Test
	@DisplayName("Testing input with only mandatory filled in")
	void testMandatory(){
		JFormattedTextField[] fields = new JFormattedTextField[100];
		for (int i = 0; i < fields.length; i++)
			fields[i] = new JFormattedTextField();
		fields[0].setValue("000");
		fields[1].setValue("1997-11-18");
		fields[2].setValue("L3R1A1");
		fields[3].setValue("1997-11-18");
		fields[4].setValue("English");
		fields[5].setValue("English");
		fields[6].setValue("Hospital");
		fields[7].setValue("Advertisement");
		fields[8].setValue("Job Help");
		fields[58].setValue("Yes");
		fields[64].setValue("Yes");
		fields[67].setValue("Yes");
		fields[88].setValue("1997-11-18");
		int result;
		result = testError.CheckIfFieldsAreValid(testForm.getfieldNames(), fields);
		assertEquals(result, -1);
	}
	
	@Test
	@DisplayName("Testing input with mandatory field not filled in")
	void testBlankMandatory(){
		JFormattedTextField[] fields = new JFormattedTextField[100];
		for (int i = 0; i < fields.length; i++)
			fields[i] = new JFormattedTextField();
		int result;
		result = testError.CheckIfFieldsAreValid(testForm.getfieldNames(), fields);
		assertEquals(result, 0);
	}
	
	@Test
	@DisplayName("Testing input with first mandatory field filled in wrong")
	void testFirstMandatoryBad(){
		JFormattedTextField[] fields = new JFormattedTextField[100];
		for (int i = 0; i < fields.length; i++)
			fields[i] = new JFormattedTextField();
		fields[0].setValue("WrongValue");
		int result;
		result = testError.CheckIfFieldsAreValid(testForm.getfieldNames(), fields);
		assertEquals(result, 0);
	}
	
	@Test
	@DisplayName("Testing input with 7th mandatory field filled in wrong")
	void testMandatoryBad(){
		JFormattedTextField[] fields = new JFormattedTextField[100];
		for (int i = 0; i < fields.length; i++)
			fields[i] = new JFormattedTextField();
		fields[0].setValue("000");
		fields[1].setValue("1997-11-18");
		fields[2].setValue("L3R1A1");
		fields[3].setValue("1997-11-18");
		fields[4].setValue("English");
		fields[5].setValue("English");
		int result;
		result = testError.CheckIfFieldsAreValid(testForm.getfieldNames(), fields);
		assertEquals(result, 6);
	}
	
}
