package jsonRead.jsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SearchJson {
	
	static 
	{
		System.out.println("Enter the Name you want to search");
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		
		
		

		try (FileReader reader = new FileReader("employees.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray employeeList = (JSONArray) obj;
			//System.out.println(employeeList);
			
		

			// Iterate and Search over employee array
			employeeList.forEach(emp -> SearchEmployeeObject((JSONObject) emp));
		

			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	static Scanner sc=new Scanner(System.in);
    static String userInput=sc.next();
	      

	
	private static void SearchEmployeeObject(JSONObject employee) {
		// Get employee object within list
		JSONObject employeeObject = (JSONObject) employee.get("employee");
		//static member
	

		// Get employee first Name in String Object to match
		String firstName = (String) employeeObject.get("firstName");
		if(firstName.equals(userInput)) 
		{
			System.out.println("Yup!!! Employee Exists !!");
			
		}

		
	}
}