package sg.com.TimeSheet;

import java.util.Date;

public class CheckInStatus {
	
	private static long internal_counter = 0;
	private long id;
	private Date checkIndateTime;
	private Date checkOutDateTime;
	
	public CheckInStatus() {
		this.id = ++internal_counter;
		this.checkIndateTime = null;
		this.checkOutDateTime = null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getCheckIndateTime() {
		return checkIndateTime;
	}

	public void setCheckIndateTime(Date checkIndateTime) {
		this.checkIndateTime = checkIndateTime;
	}

	public Date getCheckOutDateTime() {
		return checkOutDateTime;
	}

	public void setCheckOutDateTime(Date checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}

	@Override
	public String toString() {
		return "CheckInStatus [id=" + id + ", checkIndateTime=" + checkIndateTime + ", checkOutDateTime="
				+ checkOutDateTime + "]";
	}

	
	
}
