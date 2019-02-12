package jsonRead.jsonReader;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.stream.JsonGenerator;


public class JsonGeneratorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringWriter sw = new StringWriter();
        JsonGenerator jsonGenerator = Json.createGenerator(sw);
        JsonGenerator start = jsonGenerator.writeStartObject();
        start.write("firstName", "Vaibhav");
        start.write("lastName", "Singh");
        start.write("company","Atmecs Technologies");
        start.writeEnd();
        jsonGenerator.close();
 
        System.out.println(sw.toString());

	}

}
