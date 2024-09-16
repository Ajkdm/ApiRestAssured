package cookiesAndHeaders;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class MultipleCookies
{
	@Test
	public void getCookiesInfo() 
	{
		Response res=given()
				.when()
					.get("https://www.google.com/");
		
		Map<String,String> cookies=res.getCookies();
		
		for(String x:cookies.keySet()) 
		{
			String value=res.getCookie(x);
			System.out.println(x+" "+value);
		}
	}
}
