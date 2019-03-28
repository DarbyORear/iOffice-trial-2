package com.iOfficeProject.trialproject.APIclasses;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WorkPoint {
	
	//instance variables that pertain to workpoint data:
	private String _id;
	private String name;
	private String workPlaceId;
	private String workPlaceName;
	private Date lastConnect;
	private boolean connected;
	private boolean recentlyConnected;
	private boolean occupied;
	private Date occupancyChanged;
	
	//instance variables that pertain to iOffice sensor data:
	private Date startDate;
	private Date endDate;
	private String uId;
	private boolean utilized;

	

	public WorkPoint() {
		
	}
	
	//ADDING A CONSTRUCTOR WITH PARAMETERS:
	public WorkPoint(String _id, boolean occupied) {
		this._id= _id;
		this.occupied = occupied;
		
	}
	
	public WorkPoint(String _id, boolean occupied, Date lastConnect, Date occupancyChanged) {
		this._id = _id;
		this.occupied = occupied;
		this.lastConnect = lastConnect;
		this.occupancyChanged = occupancyChanged;
	}


	public Date getOccupancyChanged() {
		return occupancyChanged;
	}


	public void setOccupancyChanged(Date occupancyChanged) {
		this.occupancyChanged = occupancyChanged;
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



	public String getWorkPlaceId() {
		return workPlaceId;
	}



	public void setWorkPlaceId(String workPlaceId) {
		this.workPlaceId = workPlaceId;
	}



	public String getWorkPlaceName() {
		return workPlaceName;
	}



	public void setWorkPlaceName(String workPlaceName) {
		this.workPlaceName = workPlaceName;
	}



	public Date getLastConnect() {
		return lastConnect;
	}



	public void setLastConnect(Date lastConnect) {
		this.lastConnect = lastConnect;
	}



	public boolean isConnected() {
		return connected;
	}



	public void setConnected(boolean connected) {
		this.connected = connected;
	}



	public boolean isRecentlyConnected() {
		return recentlyConnected;
	}



	public void setRecentlyConnected(boolean recentlyConnected) {
		this.recentlyConnected = recentlyConnected;
	}



	public boolean isOccupied() {
		return occupied;
	}



	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	


//Methods for translating workpoint data to sensor data:
	
	//method to get uid for each sensor:
	public String sensorId(){
//		//get id/uuid for each sensor
//		String thisSensor = list.getWorkpoint().getUuid();
		uId = this.get_id();
		return uId;
		
	}
	
	//method to determine if sensors are utilized
	public boolean utilized(){
		
//		//get id for each sensor
		boolean occupied = this.isOccupied();
		
		if(occupied == false){
			utilized = false;
		};

		//if isOccupied, then isUtilized:
		return utilized;
	}
	
	
	//method to find date and time sensor connected:
	//NOTE: SHOULD THIS BE TYPE STRING OR DATE?
	public Date findStartDate() {
		//CoWorkr startDate is listed as: lastConnect
		startDate = this.getLastConnect();
		return startDate;

	}
	
	//method to find date and time sensor disconnected:
	public Date findEndDate() {
		//Coworkr endDate is listed as: occupancyChanged
		
		boolean occupied = this.isOccupied();
		if(!occupied) {
			endDate = this.getOccupancyChanged();
		} else {
			//return today's date and current time
		}
		
		return endDate;
		
	}

	

//method to take a Workpoint and convert it to a sensor??:
	/*public Map<String, Object> createMap(/*Map<String, Object> newSensor)*//* {
	Map<String, Object> sensor = new HashMap<String, Object>();
		sensor.put("utilized", this.isOccupied());
		sensor.put("startDate", this.getLastConnect());
		sensor.put("sensorUid", this.get_id());
		sensor.put("endDate", this.getOccupancyChanged());
		
		System.out.println(sensor);
		
		return sensor;*/
	}
	
	
	




