package com.iOfficeProject.trialproject.APIclasses;

public class FloorPlan {
	
	private String _id;
	private String name;
	private int width;
	private int height;
	private String workPlaceId;
	private String owner;
	private String workPlaceName;
	private int start;
	private int end;
	private String timezone;

	public FloorPlan() {
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getWorkPlaceId() {
		return workPlaceId;
	}

	public void setWorkPlaceId(String workPlaceId) {
		this.workPlaceId = workPlaceId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getWorkPlaceName() {
		return workPlaceName;
	}

	public void setWorkPlaceName(String workPlaceName) {
		this.workPlaceName = workPlaceName;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		return "FloorPlan [_id=" + _id + ", name=" + name + ", width=" + width + ", height=" + height + ", workPlaceId="
				+ workPlaceId + ", owner=" + owner + ", workPlaceName=" + workPlaceName + ", start=" + start + ", end="
				+ end + ", timezone=" + timezone + "]";
	}
	
	
	
	

}
