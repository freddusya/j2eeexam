package sg.com.ctcglobal.repository;

import java.util.ArrayList;
import java.util.List;

import sg.com.ctcglobal.TimeSheet.Employee;
import sg.com.ctcglobal.TimeSheet.Staff;
import sg.com.ctcglobal.TimeSheet.TeamLead;

public class EmployeeRepository {

	private final static TeamLead teamlead = new TeamLead();
	private final static Staff staff1 = new Staff("staff1");
	private final static Staff staff2 = new Staff("staff2");
	private static List<Employee> employeeList = new ArrayList<Employee>();
	
	public static Employee getEmployee(String loginName) {
		if(loginName.equalsIgnoreCase("teamlead")) {
			return teamlead;
		}else if(loginName.equalsIgnoreCase("staff1")) {		
			return staff1;
		}else if(loginName.equalsIgnoreCase("staff2")){
			return staff2;
		}
		return null;
	}
	
	public static List<Employee> getEmployeeList() {
		employeeList.add(teamlead);
		employeeList.add(staff1);
		employeeList.add(staff2);
		return employeeList;
	}
	
}
