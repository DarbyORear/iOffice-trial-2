package com.iOfficeProject.trialproject.APIclasses;

import java.util.Date;

public class iOfficeSensor {
	
	public String uId;
	public boolean utilized;
	public Date startDate;
	public Date endDate;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	//CONSTRUCTOR WITH PARAMETERS:
	public iOfficeSensor(String uId, boolean utilized, Date startDate, Date endDate) {
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
