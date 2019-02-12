package org.apache.poi.JSONExample;

import java.io.FileWriter;
import java.io.IOException;
import javax.json.JsonException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WriteJSON {

	void jsonFileWrite(String fileName) throws JsonException {

		JSONObject allEmps = new JSONObject();

		JSONArray empArray = new JSONArray();
		JSONObject empObj;
		JSONArray phoneNumbers = null;
		JSONObject phoneObj;

		empObj = new JSONObject();
		try {
			
			empObj.put("Name", "Vaibhav Singh Chauhan");
			empObj.put("Designation", "Software Engineer");
			empObj.put("Pay", "Rs. 22000/-");

			phoneNumbers = new JSONArray();
			phoneObj = new JSONObject();
			phoneObj.put("LandLine", "0512-2545865");
			phoneObj.put("Mobile", "8707645427");
			phoneNumbers.put(phoneObj);

			empObj.put("PhoneNumbers", phoneNumbers);

			empArray.put(empObj);

			empObj = new JSONObject();
			empObj.put("Name", "Sachit Mohan Gupta");
			empObj.put("Designation", "IOT Consultant");
			empObj.put("Pay", "Rs. 60000/-");

			phoneNumbers = new JSONArray();
			phoneObj = new JSONObject();
			phoneObj.put("LandLine", "022-2548796");
			phoneObj.put("Mobile", "9920709687");
			phoneNumbers.put(phoneObj);

			empObj.put("PhoneNumbers", phoneNumbers);

			empArray.put(empObj);

			allEmps.put("Employees", empArray);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			// Writing to a file
			FileWriter file = new FileWriter(fileName);
			file.write(allEmps.toString());
			file.flush();
			file.close();

			System.out.println("HURRAYY!!!! JSON FILE CREATED");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
