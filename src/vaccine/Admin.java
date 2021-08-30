package vaccine;

public class Admin {
	// Admin predefined login details
	private String adminID = "admin";
	private String password = "admin";
	String adminId = "";
	String adminP = "";

	Admin(String adminId, String password) {
		this.adminId = adminId;
		this.adminP = password;
	}

	// Admin validation part
	public boolean validateAdmin(String adminId, String password) {
		if (this.adminID.contentEquals(adminId) && this.password.equals(password))
			return true;
		else
			return false;
	}
}
