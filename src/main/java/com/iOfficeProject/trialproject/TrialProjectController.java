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



//GET WORKPOINT DATA
@RequestMapping(value = "/", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)

private ModelAndView getSensorData(HttpSession session) throws IOException {
	ModelAndView mav = new ModelAndView("coworkr-data");
	WorkPoint thisWorkPoint = null;
	//3.29:ADDING ARRAY/LIST THAT I CAN ADD SENSOR OBJECTS TO
	//ArrayList<IWorkplace> sensorList = new ArrayList<>();
	//3:29:
	ArrayList<iOfficeSensor> sensorList = new ArrayList<>();
	iOfficeSensor sensor = new iOfficeSensor();

	//3.29:ADDING A MAP TO ADD INDIVIDUAL SENSORS TO:
	//HashMap<String, iOfficeSensor> sensorMap = new HashMap<String, iOfficeSensor>();

	//3:29: NOTE: NEED TO DEFINE AND SET EACH KEY INSIDE FOR LOOP(?)
	
	
	// Create a rest template
	RestTemplate restTemplate = new RestTemplate();


	// Set up headers.
	HttpHeaders headers = new HttpHeaders();
	headers.set("authToken", authToken);
	headers.set("userId", userId);
	headers.setContentType(MediaType.APPLICATION_JSON);

	//Define url
	String url = "https://internal-us.coworkr.co/api/workPlace/gMGkJyMzxQZcoD9ed/workPoints/status";

	// Make the Request.
			/*ResponseEntity<CWorkplace> response = restTemplate.exchange(url,
			HttpMethod.GET, new HttpEntity<>(headers),
			CWorkplace.class);
	
	// Extract body from response.
			CWorkplace result = response.getBody();*/
	
	
	//ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	File myfile = new File("C:\\Users\\Wes\\Documents\\Darby stuff\\IDE\\trial-project\\target\\classes\\workPoints.json");
	
	ObjectMapper mapper = new ObjectMapper();
	//CWorkplace result;
	
	String json = new String(Files.readAllBytes(myfile.toPath()));
	//result = objectMapper.readValue(json, CWorkplace.class);
	List<WorkPoint> workpoints = mapper.readValue(
				      json, new TypeReference<List<WorkPoint>>() { });
	
	//objectMapper.readValue(testJson, )
			
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
				 
				 
				 
				 /*HashMap<String,Object> yourHash = new HashMap<String,Object>();
				 yourHash.put("message","message");
				 yourHash.put("timestamp",timestamp);
				 yourHash.put("count ",count);
				 yourHash.put("version ",version);
				 If you want to use the yourHash:

				 for(String key : yourHash.keySet()){
				   String message = (String) yourHash.get(key);
				   Datetime timestamp= (Datetime) yourHash.get(key);
				   int timestamp= (int) yourHash.get(key);
				 }*/
				 

				 
		
				 //...create map and then add map to list
				 //sensorMap.put("utilized", sensor.isUtilized());
				 //sensorMap.put("uId", sensor.getuId());
				 //sensorMap.put("startDate", sensor.getStartDate());
				 //sensorMap.put("endDate", sensor.getEndDate());
				 
			}

			
			//Json Mapper to post mock data:
			//ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			//File myfile = new File("C:\\Users\\Wes\\Documents\\Darby stuff\\IDE\\trial-project\\target\\classes\\workPoints.json");
			

			
	//******************************************************************************************************		
			String sensorAsString = mapper.writeValueAsString(sensorList);
			mav.addObject("sensors", sensorAsString);
	//*******************************************************************************************************		
			
			

	//Call method(s) from WorkPoint class to check whether workpoint statuses have changed.
			/*LocalDateTime.now();
			 //if(System.currentTimeMillis() += 500000) {}
			boolean someCondition = true;
			while(someCondition == true) {
			Long currentTime = System.currentTimeMillis();
			 //whenever currentTime += 300000 milliseconds, check status again
			
			Object updatedTime = currentTime += 3000;
			if(currentTime == updatedTime) {
			//make HTTP Request again:
				ResponseEntity<CWorkplace> newResponse = restTemplate.exchange(url,
				HttpMethod.GET, new HttpEntity<>(headers),
				CWorkplace.class);
				
				// Extract body from response.
				CWorkplace newResult = newResponse.getBody();
				
			
				for(int i = 0; i < newResult.getWorkpoints().size(); i++) {
	
					thisWorkPoint = newResult.getWorkpoints().get(i);
							
						iOfficeSensor sensor = new iOfficeSensor();
						sensor.setUtilized(thisWorkPoint.isOccupied());
						sensor.setuId(thisWorkPoint.get_id());
						sensor.setStartDate(thisWorkPoint.getLastConnect());
						sensor.setEndDate(thisWorkPoint.getOccupancyChanged());
						//add to list
						
						// Create another rest template
						RestTemplate restTemplate2 = new RestTemplate();
							


								// Set up headers for new rest template.
								HttpHeaders postHeaders = new HttpHeaders();
								postHeaders.setContentType(MediaType.APPLICATION_JSON);
								
								//3.29: create a new entity:
								//HttpEntity<ArrayList<iOfficeSensor>> body = new HttpEntity();
 
								//Define url
								String url2 = "https://hq.iofficeconnect.com/api/v3/sensors/utilization-data";
								
								//Create MultiValueMap of sensor data to post:
								//SOURCE FOR REFERENCE: https://stackoverflow.com/questions/10358345/making-authenticated-post-requests-with-spring-resttemplate-for-android
								//MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();     
								//body.add("utilized", sensor.utilized);
								//body.add("uId", sensor.uId);
								//body.add("startDate", sensor.startDate);
								//body.add("endDate", sensor.endDate);

								// Make the POST Request. //HOW TO SEND A POST REQUEST IN SPRING??
									//ResponseEntity<iOfficeSensor> response2 = restTemplate2.exchange(url2,
									//HttpMethod.POST, new HttpEntity(MultiValueMap<>, headers), (MultiValueMap) sensorList);
								
								restTemplate2.postForEntity(url2, sensorList, String.class);
							
						
							
							
									
								
									
								
								
								//ANOTHER POSSIBLE SOLUTION I FOUND FOR POSTING (BUT I THINK THIS IS BASICALLY THE SAME THING:
										// Create the request body as a MultiValueMap
										//MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();     

										//body.add("field", "value");

										// Note the body object as first parameter!
										//HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);

										//ResponseEntity<iOfficeSensor> model = restTemplate2.exchange(url2, HttpMethod.POST, httpEntity, iOfficeSensor.class);
										
										
						}
				 }
			 }*/
			
	return mav;
}


/*//NOW I NEED A CONTROLLER OR A CLASS OR SOMETHING TO POST THE INFORMATION TO THE IOFFICE APP:

//ACTUALLY I MIGHT JUST WANT TO POST THE DATA IN THE SAME LOOP AFTER I GET THE DATA AND TRANSLATE IT
@RequestMapping(value = "/post-data", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
private ModelAndView postToIOffice() {
ModelAndView mav = new ModelAndView("data-posted");

return mav;

}*/
}




// on the right track with my for loop but i shouldnt need to repeat with newResponse, etc.
//ALSO, I need to basically have an array of Maps that i'll post to ioffice's service. the array should be defined outside of my for loop.
//in my for loop, after the new sensor object is created, i need to add it to the array...

//right now, I'm creating the sensor as an object, but i still need to convert it into a map? or maybe I need to make it a map in the first place
//...that's so that Spring can parse it into json when i post it. hopefully.
//actually i might create the map separately, after i make the object...where I have the MultiValueMap thing...
//...i need an array of Maps instead

//make the HTTP request outside of the for loop...but I don't know how to do that if I need it to make the request every 5 minutes or so
//posting to the API should not be in the for loop

