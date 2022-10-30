package sg.com.TimeSheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

/*
 *
 * Our client is implementing timesheet tracking application
 * Every morning, each employee has to perform check-in, and at end of the day, check-out
 * Every 1st of the month, team lead will login to see the table showing check-in/out time for each employee working under him/her
 * 
 * Make the login page working and landing page after login is a simple page, showing 2 button, to check-in and out. 
 * Do not need to use database, just use textfile or application scope variable to store the timesheet for each staff.
 * Make login page and dashboard page also working for team lead to see the timesheet summary
 *
 */

public class TimeSheet {
	private Map<Employee, Stack<CheckInStatus>> timeSheetMap;
	
	public TimeSheet(List<Employee> listOfEmployees) {
		timeSheetMap = new TreeMap<Employee, Stack<CheckInStatus>>();
		for (Employee e : listOfEmployees) {
			Stack<CheckInStatus> checkInStatusList = new Stack<CheckInStatus>();
			timeSheetMap.put(e, checkInStatusList);
		}	
	}
	
	public void checkInEmployee(Employee employee) throws Exception {
		 if (timeSheetMap.containsKey(employee)) {
			 Stack<CheckInStatus> checkInStatusList = timeSheetMap.get(employee);
			 if(checkIfAlreadyLogOut(checkInStatusList)) {
				 CheckInStatus checkinStatus = new CheckInStatus();
				 checkinStatus.setCheckIndateTime(new Date());
				 employee.setCheckedIn(true);
				 checkInStatusList.push(checkinStatus);
				 timeSheetMap.put(employee, checkInStatusList);
			 }else {
				 throw new Exception("Employee id: "
				 		+ employee.getId()
				 		+ " Currently stil login");
			 }
			 
			
		}else {
			throw new Exception("Employee id: "
			 		+ employee.getId()
			 		+ " not found");
		}	
	}
	
	private boolean checkIfAlreadyLogin(Stack<CheckInStatus> checkInStatusList) {
		if(checkInStatusList.isEmpty()) {
			return false;
		}else {
			CheckInStatus c = checkInStatusList.peek();
			return c.getCheckIndateTime() != null && c.getCheckOutDateTime() == null;
		}
	}
	
	private boolean checkIfAlreadyLogOut(Stack<CheckInStatus> checkInStatusList) {
		if(checkInStatusList.isEmpty()) {
			return true;
		}else {
			CheckInStatus c = checkInStatusList.peek();
			return c.getCheckIndateTime() != null && c.getCheckOutDateTime() != null;
		}
		
		//return !checkIfAlreadyLogin(checkInStatusList);
	}

	public void checkOutEmployee(Employee employee) throws Exception {
		if(timeSheetMap.containsKey(employee)) {
			Stack<CheckInStatus> checkInStatusList = timeSheetMap.get(employee);
			 
			timeSheetMap.put(employee, checkInStatusList);
			 if(checkIfAlreadyLogin(checkInStatusList)) {
				 CheckInStatus checkinStatus = checkInStatusList.pop();
				 checkinStatus.setCheckOutDateTime(new Date());
				 employee.setCheckedIn(false);
				 checkInStatusList.push(checkinStatus);
				 timeSheetMap.put(employee, checkInStatusList);
				 
			 }else {
				 throw new Exception("Employee id: "
				 		+ employee.getId()
				 		+ " Currently not yet login or already log out");
			 }
		}else {
			throw new Exception("Employee id: "
			 		+ employee.getId()
			 		+ " not found");
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\n[ << TimeSheet >> ]");
		str.append("\n");
		Iterator<Entry<Employee, Stack<CheckInStatus>>> it = this.timeSheetMap.entrySet().iterator();
		
		while (it.hasNext()) {
				Entry<Employee, Stack<CheckInStatus>> e = it.next();
				str.append("{");
				str.append(e.getKey() + "=" + e.getValue());
				str.append("}");
				str.append(",");
				str.append("\n");
		}

		str.append("[--<< TimeSheet >>--]");
			
		return str.toString();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		TeamLead lead = new TeamLead();
		Staff staff = new Staff();
		Staff staff2 = new Staff();
		Staff staff3 = new Staff();
		System.out.println(lead);
		System.out.println(staff);
		System.out.println(staff2);
		System.out.println(staff3);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(lead);
		employeeList.add(staff);
		employeeList.add(staff2);

		
		TimeSheet tSheet = new TimeSheet(employeeList) ;
		System.out.println(tSheet.toString());
		
		System.out.println("\n");
		tSheet.checkInEmployee(lead);
		Thread.sleep(1000);
		tSheet.checkInEmployee(staff);
		Thread.sleep(1000);
		tSheet.checkInEmployee(staff2);
		Thread.sleep(1000);
		//System.out.println(tSheet.toString());
		tSheet.checkOutEmployee(lead);
		Thread.sleep(1000);
		tSheet.checkOutEmployee(staff);
		Thread.sleep(1000);
		tSheet.checkInEmployee(staff);
		Thread.sleep(1000);
		tSheet.checkInEmployee(lead);
		Thread.sleep(1000);
		tSheet.checkOutEmployee(lead);
		//tSheet.checkInEmployee(staff);
		
		System.out.println(tSheet.toString());
		
	}

}
