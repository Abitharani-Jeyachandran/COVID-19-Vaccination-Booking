package vaccine;

public class Admin
{
	//Admin predefined login details
	private String adminID = "admin";
	private String password = "admin";

	Admin(String adminId,String password)
	{
		this.adminID = adminId;
		this.password = password;
	}

	//Admin validation part
	public boolean validateAdmin(String adminId,String password)
	{
		if(this.adminID.contentEquals(adminId)&&this.password.equals(password))
			return true;
		else
			return false;
	}
}
