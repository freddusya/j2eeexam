package sg.com.ctcglobal.TimeSheet;

public class Staff extends Employee {

	public Staff(String username) {
		this(2, username);
	}
	
	public Staff(long roleId, String username) {
		super(roleId);
		super.setUserName(username);
	}


}
