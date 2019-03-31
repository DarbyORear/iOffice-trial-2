package com.iOfficeProject.trialproject.APIclasses;

import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class WorkPoint {
	
	private String _id;
	private String name;
	private String workPlaceId;
	private String workPlaceName;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class) 
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime lastConnect;
	private boolean connected;
	private boolean recentlyConnected;
	private boolean occupied; 
	@JsonDeserialize(using = LocalDateTimeDeserializer.class) 
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime occupancyChanged;
	

	public WorkPoint() {
		
	}
	
	public WorkPoint(String _id, boolean occupied) {
		this._id= _id;
		this.occupied = occupied;
		
	}
	
	public WorkPoint(String _id, boolean occupied, LocalDateTime lastConnect, LocalDateTime occupancyChanged) {
		this._id = _id;
		this.occupied = occupied;
		this.lastConnect = lastConnect;
		this.occupancyChanged = occupancyChanged;
	}


	public LocalDateTime getOccupancyChanged() {
		return occupancyChanged;
	}


	public void setOccupancyChanged(LocalDateTime occupancyChanged) {
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



	public LocalDateTime getLastConnect() {
		return lastConnect;
	}



	public void setLastConnect(LocalDateTime lastConnect) {
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
	
	


/*//Methods for translating workpoint data to sensor data:
	
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
	public LocalDateTime findStartDate() {
		startDate = this.getLastConnect();
		return startDate;

	}
	
	//method to find date and time sensor disconnected:
	public LocalDateTime findEndDate() {
		
		boolean occupied = this.isOccupied();
		if(!occupied) {
			endDate = this.getOccupancyChanged();
		} else {
			//return today's date and current time
			LocalDateTime.now();
		}
		
		return endDate;
		
	}*/

	
	}
	
	
	




