package com.iOfficeProject.trialproject.APIclasses;

import java.util.List;

public class IWorkplace {
	private List<iOfficeSensor> sensors;

	public List<iOfficeSensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<iOfficeSensor> sensors) {
		this.sensors = sensors;
	}

	public IWorkplace(List<iOfficeSensor> sensors) {
		super();
		this.sensors = sensors;
	}

	public IWorkplace() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
