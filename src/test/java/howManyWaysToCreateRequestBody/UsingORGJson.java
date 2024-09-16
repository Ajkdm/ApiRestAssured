package howManyWaysToCreateRequestBody;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class UsingORGJson 
{
	@Test
	public void postUsingJSONlibrary() 
	{
		JSONObject data=new JSONObject();
		
		data.put("email","test123@demo.com");
		data.put("first_name", "test1");
		data.put("last_name", "user1");
		
		//String[] coursesArr= {"java", "RestAPI"};
		
		//data.put("courses", coursesArr);
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.body("email",equalTo("test123@demo.com"))
			.body("first_name",equalTo("test1"))
			.body("last_name", equalTo("user1"))
			//.header("Content-Type","application/json;charset=utf-8");
			.log().all();
	}
	
	//@Test
	public void deleteUser() 
	{
		given()
		.when()
		.delete("https://reqres.in/api/users/")
		.then();
		
	}
}
