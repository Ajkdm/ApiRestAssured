package cookiesAndHeaders;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CoockiesAndPathQueryParam
{
	@Test
	public void pathQueryParamCookie1() 
	{
		given()
			.pathParam("myPath", "api/users")
			.pathParam("page",2)
			.pathParam("id",5)
		.when()
			.get("")
		.then()
			.cookie("CookieName","CookieValue")
			.statusCode(200);
	}
	
	@Test
	public void pathQueryParamCookie() 
	{
		given()
			
		.when()
			.get("")
		.then()
			.cookie("CookieName","CookieValue")
			.statusCode(200);
	}
}
