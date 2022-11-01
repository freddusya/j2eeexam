package sg.com.ctcglobal.TimeSheet;

public class TeamLead extends Employee {

	public TeamLead() {
		this(1);
		this.setUserName("Teamlead");
	}
	
	private TeamLead(long roleId) {
		super(roleId);
	}

}
