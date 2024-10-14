package basicValidations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class BasicRequests3 
{
	int id;
	
	@Test
	public void getRequest() 
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void postRequest() 
	{
		HashMap data=new HashMap();
		data.put("name", "user1");
		data.put("job", "teacher");
		
		id=given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.extract()
			.jsonPath().getInt("id");
		
	}
	
	@Test
	public void putRequest() 
	{
		HashMap data=new HashMap();
		data.put("name", "user4");
		data.put("job", "Principal");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200);
	}
	
	@Test
	public void deleteRequest() 
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users"+id)
		.then()
			.statusCode(204);
		
	}

}
