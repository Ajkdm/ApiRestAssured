package howManyWaysToCreateRequestBody;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UsingHasMap 
{
	@Test(priority=1)
	public void postUsingHashMap() 
	{
		HashMap data=new HashMap();
		data.put("email", "test123@demo.com");
		data.put("first_name", "test1");
		data.put("last_name", "user1");
		
		//String[] coursesArr= {"java","RestApi"};
		
		//data.put("courses",coursesArr);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
			.post("https://reqres.in/api/users/id")
		.then()
			.statusCode(201)
			.body("email",equalTo("test123@demo.com"))
			.body("first_name",equalTo("test1"))
			.body("last_name", equalTo("user1"))
			//.header("Content-Type","application/json;charset=utf-8");
			.log().all();
			
	}
	
	
	
}


/*
 * Body 
 * {
 * "id": 10, 
 * "email": "byron.fields@reqres.in", 
 * "first_name": "Byron",
 * "last_name": "Fields", 
 * }
 */