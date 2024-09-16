package howManyWaysToCreateRequestBody;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class TestPostUsingPOJO
{
	@Test
	public void testPostUsingPOJO() 
	{
		POJOClass data=new POJOClass();
		data.setEmail("user1@demo.com");
		data.setFirstName("test1");
		data.setLastName("user1");
		data.setPhone(123456789);
		
		
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
}
