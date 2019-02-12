package jsonRead.jsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("employees.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray employeeList = (JSONArray) obj;
			System.out.println(employeeList);

			// Iterate over employee array
			employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

			// Search Elements from JSON object

			// employeeList.forEach(emp->searchEmp((JSONObject)emp));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/*
	 * private static boolean searchEmp(JSONObject employee) { boolean flag=false;
	 * JSONObject employeeObject=(JSONObject)employee.get("employee"); String
	 * firstName=(String)employeeObject.get("firstName");
	 * if(firstName.equals("Vaibhav")) {
	 * //System.out.println("Yup !! Employee Exists in List"); return true; }
	 * 
	 * }
	 */

	private static void parseEmployeeObject(JSONObject employee) {
		// Get employee object within list
		JSONObject employeeObject = (JSONObject) employee.get("employee");

		// Get employee first name
		String firstName = (String) employeeObject.get("firstName");
		System.out.println(firstName);

		// Get employee last name
		String lastName = (String) employeeObject.get("lastName");
		System.out.println(lastName);

		// Get employee company name
		String website = (String) employeeObject.get("company");
		System.out.println(website);
	}
}