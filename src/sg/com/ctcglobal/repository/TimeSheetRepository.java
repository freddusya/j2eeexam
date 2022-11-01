package sg.com.ctcglobal.repository;

import sg.com.ctcglobal.TimeSheet.TimeSheet;

public class TimeSheetRepository {
	
	private static TimeSheet ts = new TimeSheet(EmployeeRepository.getEmployeeList());
	 
	private TimeSheetRepository(){}
	
	public static TimeSheet getTimeSheet(){
		return ts;
	}
	
	
}
