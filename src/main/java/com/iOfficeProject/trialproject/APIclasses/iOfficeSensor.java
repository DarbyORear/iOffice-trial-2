package com.iOfficeProject.trialproject.APIclasses;

import java.time.LocalDateTime;

public class iOfficeSensor {
	
	public String uId;
	public boolean utilized;
	public LocalDateTime startDate;
	public LocalDateTime endDate;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public boolean isUtilized() {
		return utilized;
	}
	public void setUtilized(boolean utilized) {
		this.utilized = utilized;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	//CONSTRUCTOR WITH PARAMETERS:
	public iOfficeSensor(String uId, boolean utilized, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.uId = uId;
		this.utilized = utilized;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public iOfficeSensor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//I THINK I NEED TO RE-DO THE CONSTRUCTOR WITH PARAMETERS. THE SENSOR'S PARAMETERS SHOULD BE DETERMINED
	//BY THE WORKPOINT'S PARAMETERS, LIKE THIS:
	
	/*public iOfficeSensor(boolean utilized, Date startDate, String uId, Date endDate) {
		super();
		WorkPoint._id = uId;
		WorkPoint.set_id(uId);
		WorkPoint.get_id() = uId;
	}*/
	

}
