package com.iOfficeProject.trialproject.APIclasses;

public class WorkPoints {
	
	private WorkPoint workpoint;
	
	public WorkPoint getWorkpoint() {
		return workpoint;
	}
	
	
	public void setWorkpoint(WorkPoint workpoint) {
		this.workpoint = workpoint;
	}

	@Override
	public String toString() {
		return "WorkPoint [workpoint=" + workpoint + "]";
	}

	public WorkPoints(WorkPoint workpoint) {
		super();
		this.workpoint = workpoint;
	}
	
	public WorkPoints() {

	}

}
