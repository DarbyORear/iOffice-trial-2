package com.iOfficeProject.trialproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TrialProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrialProjectApplication.class, args);
		
		//iOfficeSensor sensor = new iOfficeSensor(String uId, boolean utilized, Date startDate, Date endDate);
		
		//this doesn't work but it might work if I create a new WorkPoint object using the values
		//from the API.
		
		//iOfficeSensor sensor = new iOfficeSensor();
		//sensor.setuId(WorkPoint.get_id());
		
		
		
		//WorkPoint wp = new WorkPoint();
		
		
		//User partner = userDao.findUserById(h);
		//partner.setPartnerId(user.getId());
		
		
		
		//WorkPoint.createMap(); //that doesn't work. error - can't make static reference to non-static method.
	}
	
//1. First, I would need a method for getting info from CoWorkr. This is in my Controller right now. I'll do this later.
	
	
//2. Then, I would need a method for translating a list of CoWorkr data into a list of iOffice data. This should use the 
	//next method (step 3.).
	//NOTE: IT MIGHT STILL MAKE SENSE TO HAVE A SEPARATE CLASS FOR A WORKPOINT AND FOR AN IOFFICE SENSOR;
			//but i shouldn't need a separate class just for getting a list of workpoints.
	
	
		//public List toIOfficeList(Date start, Date end){
		//make a list of CoWorkr workpoints
			//List<WorkPoints> CoworkrWorkPoints = null;
		//make a list of iOffice "workpoints"?
			//List<iOfficeSensor> iOfficeSensors = null;

		
		
		//return iOfficeSensors;
	//}
	

//3. Then, I would need a method for translating a single CoWorkr workpoint into an iOffice workpoint.

	

//4. Then, I would need to post the data to iOffice's API. I'll do this later.


//Let's try this again with Maps:
	//public Map method() {
	//Map workpoints = new HashMap();
	//workpoints.put("id", WorkPoint.get_id()); //this doesn't work, but seems like it should be something like this, in a for loop
	
	//for(int i=0; i<workpoints.size(); i++) { //note: this won't work...workpoints is a new hashmap, i need to be looking for the size of the list of workpoints that already exists in coworkr
		
	//}
	
	//}
}
