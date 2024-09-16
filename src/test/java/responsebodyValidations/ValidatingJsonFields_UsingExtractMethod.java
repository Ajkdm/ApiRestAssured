package responsebodyValidations;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ValidatingJsonFields_UsingExtractMethod
{
	String url="https://reqres.in/api/users";
	@Test
	public void dataTypeValidation() 
	{
		Object response = given()
			    .when()
			    	.get(url)
			    .then()
			    	.extract().path("data[0].first_name");
		
		System.out.println(response);
		Assert.assertTrue(response.equals("George"));	
	}
	
	@Test
	public void last_name() 
	{
		Object response = given()
			    .when()
			    	.get(url)
			    .then()
			    	.extract().path("data[0].last_name");
		
		System.out.println(response);
		Assert.assertTrue(response.equals("Bluth"));	
			
	}
	
	@Test
	public void email() 
	{
		Object response=given()
				
				.when()
					.get(url)
				.then()
					.extract().path("data[0].email");
		
		System.out.println(response);
		Assert.assertTrue(response.equals("george.bluth@reqres.in"));
	}
}
