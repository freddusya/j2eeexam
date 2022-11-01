package sg.com.ctcglobal.TimeSheet;
import sg.com.ctcglobal.Util.NumberUtil;

public class Employee implements Comparable<Employee> {
 
	private static long internal_counter = 0;
	private long id;
	private long roleId;
	private boolean isCheckedIn;
	private String userName;

	public Employee(long roleId) {
		this.id = ++internal_counter;
		this.roleId = roleId;
	}

	public long getId() {
		return id;
	}
	
	public String getIdStr() {
		return NumberUtil.formatIDStr(this.id);
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public boolean isCheckedIn() {
		return isCheckedIn;
	}

	public void setCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", roleId=" + roleId + ", isCheckedIn=" + isCheckedIn + "]";
	}

	@Override
	public int compareTo(Employee e) {
		if (this.getId() == e.getId())
			return 0;
		else if (this.getId() > e.getId())
			return 1;
		else
			return -1;
	}

}
