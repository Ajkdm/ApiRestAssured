package responsebodyValidations;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class NormalWay 
{ 
	String url="https://reqres.in/api/users";
	@Test
	public void validateJsonBody_Approach1() 
	{
		given()
			.contentType(ContentType.JSON)
		.when()
			.get(url)
		.then()
			.body("data[0].first_name", Matchers.equalTo("George"))
			.body("data[0].last_name",Matchers.equalTo("Bluth"));
	}
	
	@Test
	public void validateJsonBody_Aproach2() 
	{
		Response response=given()
			.contentType(ContentType.JSON)
		.when()
			.get(url);
		String fn=response.jsonPath().get("data[0].first_name").toString();
		String lm=response.jsonPath().get("data[0].last_name").toString();
		System.out.println(fn+" "+lm);
		Assert.assertEquals(fn, "George");
		Assert.assertEquals(lm, "Bluth");	
	}
	
	@Test
	public void getAllDataFromAnArray() 
	{
		Response res=given()
						.contentType(ContentType.JSON)
					.when()
						.get(url);
		
		JSONObject jo=new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("data").length();i++) 
		{
			String fn=jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			
			System.out.println(fn);
		}
	}
	
	@Test
	public void compareOneNameWithAll() 
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.when()
				.get(url);
		
		JSONObject jo=new JSONObject(res.asString());
		
		boolean status=false;
		
		for(int i=0;i<jo.getJSONArray("data").length();i++) 
		{
			String firstName=jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			
			if(firstName.equals("Tracey")) 
			{
				System.out.println(firstName);
				status=true;
				break;
			}
		}
		
	Assert.assertEquals(status, true);
		
	}
}
