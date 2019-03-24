package com.iOfficeProject.trialproject.APIclasses;

import java.util.List;


public class WorkPlacesResults {
	
	private List <WorkPlaces> workplaces;
	
	//NOTE: This is what Spring adds automatically when I click on the first option for fixing the error in the mav.addObject..part of the controller
	//public Object getWorkplaces;
	
	public List <WorkPlaces> getWorkplaces(){
		return workplaces;
	}
	
	public void setWorkplaces(List<WorkPlaces> workplaces) {
		this.workplaces = workplaces;
	}
	
	public WorkPlacesResults(List<WorkPlaces> workplaces) {
		super();
		this.workplaces = workplaces;
	}
	
	@Override
	public String toString() {
		return "Senses [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
