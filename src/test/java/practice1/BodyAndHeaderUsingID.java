package practice1;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BodyAndHeaderUsingID 
{
	String token="fcbc03de199ba0a12067279f563afbeefc8449d70d438535afa457bcb3bf802f";
	@Test
	public void Approach1() 
	{
	 given()
		.header("Authorization","Bearer"+token)
		.contentType("ContentType/json")
	.when()
		.get("https://gorest.co.in/public/v2/users/7413012")
	.then()
		.statusCode(200)
	 	.body("name", Matchers.equalTo("Rev. Acharyasuta Banerjee"))
	 	.body("email", Matchers.equalTo("acharyasuta_banerjee_rev@dicki.test"))
	 	.header("Content-Type", "application/json; charset=utf-8");
	}
	
	@Test
	public void Approach2() 
	{
	Response res= given()
		.header("Authorization","Bearer"+token)
		.contentType("ContentType/json")
	.when()
		.get("https://gorest.co.in/public/v2/users/7413012");
	
	     Assert.assertEquals(res.statusCode(), 200);
	     Assert.assertEquals(res.jsonPath().getString("name"),"Rev. Acharyasuta Banerjee");
	     Assert.assertEquals(res.jsonPath().getString("email"),"acharyasuta_banerjee_rev@dicki.test");
	     Assert.assertEquals(res.headers().getValue("Content-Type"),"application/json; charset=utf-8");
	}
}
