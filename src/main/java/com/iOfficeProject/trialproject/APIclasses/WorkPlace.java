package com.iOfficeProject.trialproject.APIclasses;

import java.util.List;

public class WorkPlace {
	
	private List <WorkPlace> workplaces;
	private String _id;
	private String name;
	private String address;
	private String timezone;
	private String group;
	private String startDate;
	private String endDate;
	private int activeStartHour;
	private int activeEndHour;
	
	
//	private String id;
//	private String name;
//	private String address;
//	private Group group;
//	private String owner;
//	private String formattedAddress;
//	private Location location;
//	private String timezone;
//	private boolean sleep;
//	private String start;
//	private String end;
//	private String activeStartHour;
//	private String activeEndHour;
	
	
	
	
	public WorkPlace() {
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getActiveStartHour() {
		return activeStartHour;
	}

	public void setActiveStartHour(int activeStartHour) {
		this.activeStartHour = activeStartHour;
	}

	public int getActiveEndHour() {
		return activeEndHour;
	}

	public void setActiveEndHour(int activeEndHour) {
		this.activeEndHour = activeEndHour;
	}

	public List <WorkPlace> getWorkplaces() {
		return workplaces;
	}

	public void setWorkplaces(List <WorkPlace> workplaces) {
		this.workplaces = workplaces;
	}
	
	
}
	





