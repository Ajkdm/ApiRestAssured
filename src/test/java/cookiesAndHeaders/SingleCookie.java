package cookiesAndHeaders;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class SingleCookie 
{
	@Test
	public void testCookies() 
	{
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC","AEC")
			.log().all();
	}
}
