package jsonRead.jsonReader;
import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class JsonWrite
 {
	static String companyName="Atmecs Technologies Private Limited";
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        //First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Tejaswini");
        employeeDetails.put("lastName", "Shinde");
        employeeDetails.put("company", companyName);
         
        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);
         
        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Vaibhav");
        employeeDetails2.put("lastName", "Singh");
        employeeDetails2.put("company", companyName);
         
        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("employee", employeeDetails2);
         
        //Third Employee
        JSONObject employeeDetails3 = new JSONObject();
        employeeDetails3.put("firstName", "Shubham");
        employeeDetails3.put("lastName", "Singh");
        employeeDetails3.put("company", companyName);
         
        JSONObject employeeObject3 = new JSONObject();
        employeeObject3.put("employee", employeeDetails3);
        
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);
        employeeList.add(employeeObject3);
         
        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {
 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}