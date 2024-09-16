package howManyWaysToCreateRequestBody;

public class POJOClass
{
	private String email;
	private String first_name;
	private String last_name;
	private int phone;
	
	private String status;

	String[] course;

	public String getemail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email=email;
	}
	
	//-------------------------------------
	
	public String getFirstName() 
	{
		return first_name;	
	}
	public void setFirstName(String first_name) 
	{
		this.first_name=first_name;
	}
	
	//-------------------------------------
	
	public String getLastName() 
	{
		return last_name;
	}
	public void setLastName(String last_name) 
	{
		this.last_name=last_name;
	}
	
	public int getPhone() 
	{
		return phone;
	}
	public void setPhone(int phone) 
	{
		this.phone=phone;
	}
	
	public String setAndGetStatus(String status) 
	{
		this.status=status;
		return status;
	}
}
