package org.apache.poi.JSONExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchJSON {
	 void jsonFileSearch(String fileName) throws JSONException {

			try {

				Scanner scanner = new Scanner(new File(fileName));
				String jsonString = scanner.useDelimiter("\\A").next();
				scanner.close();
				System.out.println("jsonString =" + jsonString);
				JSONObject empObj = new JSONObject();
				//JSONObject phoneObj = new JSONObject();
                
				JSONObject jsonObject = new JSONObject(jsonString);
                boolean flag=false;
				JSONArray jsonArray = jsonObject.getJSONArray("Employees");
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);
				String userInput=sc.nextLine();

				for (int j = 0; j < jsonArray.length(); j++) {
					empObj = jsonArray.getJSONObject(j);
					String nameOfCountry = (String) empObj.get("Name");
					//System.out.println("Name : " + nameOfCountry);
					
					if(nameOfCountry.equals(userInput)) 
					{
						//System.out.println("Yes!! Employee Exists with Name : " + userInput);
						flag=true;
						break;
						
					}
                    
				//	String population = (String) empObj.get("Designation");
				//	System.out.println("Designation: " + population);

				//	System.out.println("Phone Numbers are :");
				//	JSONArray phoneNumbers = (JSONArray) empObj.get("PhoneNumbers");
				//	for (int i = 0; i < phoneNumbers.length(); i++) {
				//		phoneObj = phoneNumbers.getJSONObject(i);
				//		System.out.println(" Land Line " + phoneObj.get("LandLine"));
				//		System.out.println(" Mobile " + phoneObj.get("Mobile"));
				//	}

				}
				  if(flag==true) 
                  {
                	  System.out.println("Yes!! Employee Exists with Name : " + userInput);
                  }
                  else
                  {
                	  System.out.println("Sorry!! No Employee Exists with Name : " + userInput);
                  }

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	 }

}
