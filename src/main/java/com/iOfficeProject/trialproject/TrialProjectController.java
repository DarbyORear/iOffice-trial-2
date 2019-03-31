package com.iOfficeProject.trialproject;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
//import java.time.LocalDateTime; //USE THIS TO GET CURRENT DATE/TIME: Object time = LocalDateTime.now();

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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
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


////3/30/19: COMMENTING OUT THIS SECTION OF CODE BECAUSE I'VE REORGANIZED IT BELOW//////////////////////////////////////////////////////////////////////////////////////
/*
//GET WORKPOINT DATA
@RequestMapping(value = "/", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)

private ModelAndView getSensorData(HttpSession session) throws IOException {
	ModelAndView mav = new ModelAndView("coworkr-data");
	WorkPoint thisWorkPoint = null;
	//ArrayList<IWorkplace> sensorList = new ArrayList<>();
	ArrayList<iOfficeSensor> sensorList = new ArrayList<>();
	iOfficeSensor sensor = new iOfficeSensor();
	//HashMap<String, iOfficeSensor> sensorMap = new HashMap<String, iOfficeSensor>();
	
	
	// Create a rest template
	RestTemplate restTemplate = new RestTemplate();


	// Set up headers.
	HttpHeaders headers = new HttpHeaders();
	headers.set("authToken", authToken);
	headers.set("userId", userId);
	headers.setContentType(MediaType.APPLICATION_JSON);

	//Define url
	String url = "https://internal-us.coworkr.co/api/workPlace/gMGkJyMzxQZcoD9ed/workPoints/status";

/////NORMALLY, THIS PART WOULD NOT BE COMMENTED OUT - THIS WOULD BE THE ACTUAL REQUEST TO TEH COWORKR API//////////////
	// Make the Request.
			ResponseEntity<CWorkplace> response = restTemplate.exchange(url,
			HttpMethod.GET, new HttpEntity<>(headers),
			CWorkplace.class);
	
	// Extract body from response.
			CWorkplace result = response.getBody();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Using classLoader to read mock API information from file, due to authorization issues. Normally would use the API call above.
	//ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	File myfile = new File("C:\\Users\\Wes\\Documents\\Darby stuff\\IDE\\trial-project\\target\\classes\\workPoints.json");
	
	ObjectMapper mapper = new ObjectMapper();
	//CWorkplace result;
	
	String json = new String(Files.readAllBytes(myfile.toPath()));
	//result = objectMapper.readValue(json, CWorkplace.class);
	List<WorkPoint> workpoints = mapper.readValue(json, new TypeReference<List<WorkPoint>>() { });
				
			//write a for loop that will loop through each Workpoint and get its id;
			for(int i = 0; i < workpoints.size(); i++) {
				//loop through each workpoint and get i. SEPARATE THIS OUT INTO A METHOD AND CALL IT HERE
				 thisWorkPoint = workpoints.get(i);
				 System.out.println("workpoint id: " + thisWorkPoint.get_id());
				 
				 //iOfficeSensor sensor = new iOfficeSensor();
				 sensor.setUtilized(thisWorkPoint.isOccupied());
				 sensor.setuId(thisWorkPoint.get_id());
				 sensor.setStartDate(thisWorkPoint.getLastConnect());
				 sensor.setEndDate(thisWorkPoint.getOccupancyChanged());
				 //add to list
				 sensorList.add(sensor);
				 
			
	//******************************************************************************************************		
			String sensorAsString = mapper.writeValueAsString(sensorList);
			mav.addObject("sensors", sensorAsString);
	//*******************************************************************************************************		
			mav.addObject("workpoints", json);
*/
			
//NOTE: I DON'T WANT TO TOUCH ANYTHING ABOVE THIS LINE BECUASE IT ALL WORKS./////////////////////////////////////////////////////////////////
			
/////3/30/19: END OF COMMENTED OUT ORIGINAL CODE BLOCK////////////////////////////////////////////////////////////////////////////////////////////////////////////

			
////3/30/19: THIS IS THE FINAL CODE FOR THE REAL API CALLS/POSTS://///////////////////////////////////////////////////////////////////////
		//NOTE: Right now, when I run this code, it times out. The mock call will probably time out too because I told it to only start checking after 5 minutes....
/*
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
			
			//whenever currentTime += 300000 milliseconds, check status again
			//Object updatedTime = currentTime += 3000;
			//if(currentTime == updatedTime) {

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
		*/	
///////3/30/19: END OF FINAL CODE FOR REAL API CALLS/POSTS/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////3/30/19: THIS IS THE FINAL CODE FOR THE MOCK CALLS/POSTS TO THE "API"://////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/mock-calls", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	private ModelAndView getAndPostMockData() throws IOException {	
		
		//1. set variables
		ModelAndView mav = new ModelAndView("coworkr-data");
		WorkPoint thisWorkPoint = null;
		ArrayList<iOfficeSensor> sensorList = new ArrayList<>();
		iOfficeSensor sensor = new iOfficeSensor();
		//boolean someCondition = true;
		

		//get local time:
		//LocalDateTime.now();
		//get current time:
		Long currentTime = System.currentTimeMillis();

		//start a loop so it checks the data every 5 minutes (for the mock call, of course, the data will stay the same,
		//but with a real call it would get the new API data and update it):
		while(currentTime == System.currentTimeMillis()) {
		
		//whenever currentTime += 300000 milliseconds, check status again
		//Object updatedTime = currentTime += 300000;
		//if(currentTime == updatedTime) {
		
			File myfile = new File("C:\\Users\\Wes\\Documents\\Darby stuff\\IDE\\trial-project\\target\\classes\\workPoints.json");
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = new String(Files.readAllBytes(myfile.toPath()));
			
			List<WorkPoint> workpoints = mapper.readValue(json, new TypeReference<List<WorkPoint>>() { });
						
					//write a for loop that will loop through each Workpoint and get its id;
					for(int i = 0; i < workpoints.size(); i++) {
						//loop through each workpoint and get i. SEPARATE THIS OUT INTO A METHOD AND CALL IT HERE
						 thisWorkPoint = workpoints.get(i);
						 System.out.println("workpoint id: " + thisWorkPoint.get_id());
						 mav.addObject("workpoints", json);
						 
						 //iOfficeSensor sensor = new iOfficeSensor();
						 sensor.setUtilized(thisWorkPoint.isOccupied());
						 sensor.setuId(thisWorkPoint.get_id());
						 sensor.setStartDate(thisWorkPoint.getLastConnect());
						 sensor.setEndDate(thisWorkPoint.getOccupancyChanged());
						 //add to list
						 sensorList.add(sensor);
						 
						 String sensorAsString = mapper.writeValueAsString(sensorList);
						 mav.addObject("sensors", sensorAsString);
					
						 currentTime += 300000;
					
					
					//To post the data:
					
					//create a RestTemplate:
					//RestTemplate restTemplate = new RestTemplate();
					
					//set up headers:
					//HttpHeaders headers = new HttpHeaders();
					//headers.set("authToken", authToken);
					//headers.set("userId", userId);
					//headers.setContentType(MediaType.APPLICATION_JSON);

					//Define url
					//String url = "https://hq.iofficeconnect.com/api/v3/sensors/utilization-data";

					// Make the POST Request.
					//restTemplate.postForEntity(url, sensorList, String.class);

					}
		}
		//}
		
		return mav;
	}

//////3/30/19: THIS IS THE END OF THE FINAL CODE FOR THE MOCK CALLS/POSTS TO THE "API"///////////////////////////////////////////////////////////////////////////////////////////////////////
}


