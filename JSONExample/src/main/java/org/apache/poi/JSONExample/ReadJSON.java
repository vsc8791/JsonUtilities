package org.apache.poi.JSONExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJSON {

	 void jsonFileRead(String fileName) throws JSONException {

		try {

			Scanner scanner = new Scanner(new File(fileName));
			String jsonString = scanner.useDelimiter("\\A").next();
			scanner.close();
			System.out.println("jsonString =" + jsonString);
			JSONObject empObj = new JSONObject();
			JSONObject phoneObj = new JSONObject();

			JSONObject jsonObject = new JSONObject(jsonString);

			JSONArray jsonArray = jsonObject.getJSONArray("Employees");

			for (int j = 0; j < jsonArray.length(); j++) {
				empObj = jsonArray.getJSONObject(j);
				String nameOfCountry = (String) empObj.get("Name");
				System.out.println("Name : " + nameOfCountry);

				String population = (String) empObj.get("Designation");
				System.out.println("Designation: " + population);

				System.out.println("Phone Numbers are :");
				JSONArray phoneNumbers = (JSONArray) empObj.get("PhoneNumbers");
				for (int i = 0; i < phoneNumbers.length(); i++) {
					phoneObj = phoneNumbers.getJSONObject(i);
					System.out.println(" Land Line " + phoneObj.get("LandLine"));
					System.out.println(" Mobile " + phoneObj.get("Mobile"));
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
