package responsebodyValidations;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class PrintAllFirstNameInAnArray 
{
	@Test
	public void printFirstNames() 
	{
		Response res=given()
					.contentType(ContentType.JSON)
				
				.when()
					.get("https://reqres.in/api/users");
		
		JSONObject jo=new JSONObject(res.asString());
		
		boolean status=false;
		
		for(int i=0;i<jo.getJSONArray("data").length();i++) 
		{
			String firstName=jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			String lastName=jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			System.out.print(firstName+" "+lastName);
			System.out.println();
			
			
		}
	}
}
