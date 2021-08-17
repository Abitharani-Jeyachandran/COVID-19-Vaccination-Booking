package vaccine;

public class Admin 
{
	private String adminID = "admin";
	private String password = "123";
	
	Admin(String adminId,String password)
	{
		this.adminID = adminId;
		this.password = password;
	}
	
	public boolean validateAdmin(String adminId,String password)
	{
		if(this.adminID.contentEquals(adminId)&&this.password.equals(password))
			return true;
		else
			return false;
	}
}
