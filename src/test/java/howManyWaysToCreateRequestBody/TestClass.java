package howManyWaysToCreateRequestBody;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



public class TestClass 
{
	public void usingHashMap() 
	{
		HashMap<Object,Object> data=new HashMap<>();
		data.put("name", "user1");
		data.put("phone", 123456);

		given()
			.body(data.toString())
		.when()
		.then();
	}

	public void usingJsonObject() 
	{
		JSONObject data=new JSONObject();
		data.put("name", "user1");
		data.put("phone", 123456);

		given()
			.body(data.toString())
		.when()
		.then();
	}

	public void usingExternalFile() throws IOException 
	{
		File file=new File("./TestData/body.json");
		FileReader rd=new FileReader(file);

		JSONTokener jt=new JSONTokener(rd);
		JSONObject js=new JSONObject(jt);

		given()
			.body(js.toString())
		.when()
		.then();
	}
	
	@Test
	public void usingPOJOClass()  
	{
		POJOClass data=new POJOClass();
		data.setFirstName("Ajay");
		data.setLastName("Kadam");
		data.setEmail("testdemo@demo.com");
		data.setPhone(1234567890);
		
		System.out.println(data.getFirstName());
		System.out.println(data.getLastName());
		System.out.println(data.getemail());
		System.out.println(data.getPhone());
		
		System.out.println(data.setAndGetStatus("Active"));
	}
}
