package com.iOfficeProject.trialproject.APIclasses;

public class WorkPoint {

	private String _id;
	private String uuid;
	private String name;
	private String firmwareVersion;
	private String workPlaceId;
	private String workPlaceName;
	private String lastConnect;
	private boolean connected;
	private boolean recentlyConnected;
	private boolean occupied;
	private String occupiedBy;
	private String occupyReason;
	private int rssi;
	private int battery;
	private double optical;
	private String floorPlanId;
	private int floorPlanX;
	private int floorPlanY;
	private String floorPlanName;
	private String tags;
	private String notes;
	

	public WorkPoint() {
		
	}


	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public String getUuid() {
		return uuid;
	}



	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFirmwareVersion() {
		return firmwareVersion;
	}



	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
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



	public String getLastConnect() {
		return lastConnect;
	}



	public void setLastConnect(String lastConnect) {
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



	public String getOccupiedBy() {
		return occupiedBy;
	}



	public void setOccupiedBy(String occupiedBy) {
		this.occupiedBy = occupiedBy;
	}



	public String getOccupyReason() {
		return occupyReason;
	}



	public void setOccupyReason(String occupyReason) {
		this.occupyReason = occupyReason;
	}



	public int getRssi() {
		return rssi;
	}



	public void setRssi(int rssi) {
		this.rssi = rssi;
	}



	public int getBattery() {
		return battery;
	}



	public void setBattery(int battery) {
		this.battery = battery;
	}



	public double getOptical() {
		return optical;
	}



	public void setOptical(double optical) {
		this.optical = optical;
	}



	public String getFloorPlanId() {
		return floorPlanId;
	}



	public void setFloorPlanId(String floorPlanId) {
		this.floorPlanId = floorPlanId;
	}



	public int getFloorPlanX() {
		return floorPlanX;
	}



	public void setFloorPlanX(int floorPlanX) {
		this.floorPlanX = floorPlanX;
	}



	public int getFloorPlanY() {
		return floorPlanY;
	}



	public void setFloorPlanY(int floorPlanY) {
		this.floorPlanY = floorPlanY;
	}



	public String getFloorPlanName() {
		return floorPlanName;
	}



	public void setFloorPlanName(String floorPlanName) {
		this.floorPlanName = floorPlanName;
	}



	public String getTags() {
		return tags;
	}



	public void setTags(String tags) {
		this.tags = tags;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
