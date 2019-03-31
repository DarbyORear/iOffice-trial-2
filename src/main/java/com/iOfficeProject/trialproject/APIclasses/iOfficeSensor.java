package com.iOfficeProject.trialproject.APIclasses;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "sensor")
public class iOfficeSensor {
		
	public String uId;
	public boolean utilized;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss'Z'") 
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	public LocalDateTime startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss'Z'") 
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	public LocalDateTime endDate;
	
	//@JsonValue
	public String getuId() {
		return uId;
	}
	
	public void setuId(String uId) {
		this.uId = uId;
	}
	
	//@JsonValue
	public boolean isUtilized() {
		 return utilized;
	}
	
	public void setUtilized(boolean utilized) {
		this.utilized = utilized;
	}
	
	//@JsonValue
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDateTime string) {
		this.startDate = string;	
	}
	
	//@JsonValue
	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public iOfficeSensor(boolean utilized, LocalDateTime startDate, String uId, LocalDateTime endDate) {
		super();
		this.utilized = utilized;
		this.startDate = startDate;
		this.uId = uId;
		this.endDate = endDate;
	}
	
	public iOfficeSensor() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
