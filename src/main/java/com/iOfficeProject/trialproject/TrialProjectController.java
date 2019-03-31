package com.iOfficeProject.trialproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
//import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iOfficeProject.trialproject.APIclasses.CWorkplace;
import com.iOfficeProject.trialproject.APIclasses.WorkPoint;
import com.iOfficeProject.trialproject.APIclasses.iOfficeSensor;

@RestController
public class TrialProjectController {
	
@Value("${authToken}")
String authToken;

@Value("${userId}")
String userId;

			
////CODE FOR THE REAL API CALLS/POSTS://///////////////////////////////////////////////////////////////////////////////////////////////
@RequestMapping(value = "/", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	private ModelAndView getAndPostData() throws IOException {
			
			//1. set variables
			ModelAndView mav = new ModelAndView("coworkr-data");
			WorkPoint thisWorkPoint = null;
			ArrayList<iOfficeSensor> sensorList = new ArrayList<>();
			iOfficeSensor sensor = new iOfficeSensor();
			//boolean someCondition = true;

			//create a RestTemplate:
			RestTemplate restTemplate = new RestTemplate();
			
			//set up headers:
			HttpHeaders headers = new HttpHeaders();
			headers.set("authToken", authToken);
			headers.set("userId", userId);
			headers.setContentType(MediaType.APPLICATION_JSON);

			//Define url
			String url = "https://internal-us.coworkr.co/api/workPlace/gMGkJyMzxQZcoD9ed/workPoints/status";
	
			//get current time:
			Long currentTime = System.currentTimeMillis();

			//start a loop so it checks the data every 5 minutes:
			while(System.currentTimeMillis() == currentTime) {

			//make HTTP Request to CoWorkr API
			ResponseEntity<CWorkplace> response = restTemplate.exchange(url,
			HttpMethod.GET, new HttpEntity<>(headers),
			CWorkplace.class);
				
			// Extract body from response.
			CWorkplace result = response.getBody();
				
			//loop through list of workpoints and get each workpoint:
			for(int i = 0; i < result.getWorkpoints().size(); i++) {
				thisWorkPoint = result.getWorkpoints().get(i);
					
					//set properties of sensor object with corresponding workpoint values
					sensor.setUtilized(thisWorkPoint.isOccupied());
					sensor.setuId(thisWorkPoint.get_id());
					sensor.setStartDate(thisWorkPoint.getLastConnect());
					sensor.setEndDate(thisWorkPoint.getOccupancyChanged());
					
					//add new sensor to ArrayList	
					 sensorList.add(sensor);
					 
					//tell it to 
					 currentTime +=3000;
			}
					 
			//post the updated data to the iOffice API:
			//Define post url
			String url2 = "https://hq.iofficeconnect.com/api/v3/sensors/utilization-data";
			
			// Make the POST Request.
			restTemplate.postForEntity(url2, sensorList, String.class);
			
			//add get and post data to view:
			mav.addObject("sensors", sensorList);
			mav.addObject("workpoints", result);

			}
			
			
			//update view:
			return mav;
	}



//////THIS IS THE CODE FOR THE MOCK CALLS/POSTS:///////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/mock-calls", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	private ModelAndView getAndPostMockData() throws IOException {	
		
		//set variables
		ModelAndView mav = new ModelAndView("coworkr-data");
		WorkPoint thisWorkPoint = null;
		ArrayList<iOfficeSensor> sensorList = new ArrayList<>();
		
		//get current time:
		Long currentTime = System.currentTimeMillis();

		//start a loop so it checks the data every 5 minutes (for the mock call, of course, the data will stay the same,
		//but with a real call it would get the new API data and update it):
		while(currentTime == System.currentTimeMillis()) {
		
			//Reading mock API information directly from file, due to authorization issues. Normally would use the API call above.
//FIXME: try to figure out how to fix filepath/classpath so that classloader will work intead of typing in the full classpath in the code	
			//ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			File myfile = new File("C:\\Users\\Wes\\Documents\\Darby stuff\\IDE\\trial-project\\target\\classes\\workPoints.json");
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = new String(Files.readAllBytes(myfile.toPath()));
			
			List<WorkPoint> workpoints = mapper.readValue(json, new TypeReference<List<WorkPoint>>() { });
						
					//write a for loop that will loop through each Workpoint and get its id;
					for(int i = 0; i < workpoints.size(); i++) {
						//loop through list of workpoints and get individual workpoints.
						 thisWorkPoint = workpoints.get(i);
						 System.out.println("workpoint id: " + thisWorkPoint.get_id());
						 mav.addObject("workpoints", json);
						 
						 iOfficeSensor sensor = new iOfficeSensor();
						 sensor.setUtilized(thisWorkPoint.isOccupied());
						 sensor.setuId(thisWorkPoint.get_id());
						 sensor.setStartDate(thisWorkPoint.getLastConnect());
						 sensor.setEndDate(thisWorkPoint.getOccupancyChanged());
						 //add to list
						 sensorList.add(sensor);
						 
						 currentTime += 300000;
					}
						 
						 String sensorAsString = mapper.writeValueAsString(sensorList);
						 mav.addObject("sensors", sensorAsString);
						 System.out.println(sensorAsString);

					}
		
		return mav;
	}

}


