package group13.cscc01.forms;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import group13.adam.files.*;
import java.util.LinkedHashMap;

public class FormManager {
  private HashMap<String, String> optFields;
  private HashMap<String, String> mandFields;
  private String[] infoArray;
  protected Map<String, String> infoMap;
  
  public FormManager(HashMap<String, String> mand, HashMap<String, String> opt) {
    optFields = opt;
    mandFields = mand;
    restOfConstructor();
  }
  
  public FormManager(String fileName) {
    try {
      FileManager.getFromFile(fileName, this);
      restOfConstructor();
    } catch (IOException e) {
      System.out.println("Something's wrong :)");
    }
  }
  

  private void restOfConstructor() {
    int index = 0;
    infoArray = new String[optFields.size() + mandFields.size()];
    for (Map.Entry<String, String> entry : mandFields.entrySet()) {
      infoArray[index] = entry.getKey();
      index++;
    }
    for (Map.Entry<String, String> entry : optFields.entrySet()) {
      infoArray[index] = entry.getKey();
      index++;
    }
    infoMap = new LinkedHashMap<String, String>();
    for (int i = 0; i < infoArray.length; i++) {
      this.infoMap.put(infoArray[i], "");
    }
  }

  public void setOptFields(HashMap<String, String> opt) {
    optFields = opt;

  }

  public void setMandFields(HashMap<String, String> mand) {
    mandFields = mand;
  }

  public HashMap<String, String> getMandFields() {
    return mandFields;
  }

  public HashMap<String, String> getOptFields() {
    return optFields;
  }

  public Map<String, String> getInfoMap() {
    return infoMap;
  }

  public String[] getInfoArray() {
    return this.infoArray;
  }

  public boolean updateInfoMap(String key, String value) {
    if (this.infoMap.containsKey(key)) {
      this.infoMap.put(key, value);
      return true;
    }
    return false;
  }

}
