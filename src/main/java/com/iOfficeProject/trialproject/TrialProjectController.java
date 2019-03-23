package com.iOfficeProject.trialproject;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.iOfficeProject.trialproject.APIclasses.FloorPlan;
import com.iOfficeProject.trialproject.APIclasses.WorkPlace;

@Controller
public class TrialProjectController {
	
@Value("${authToken}")
String authToken;

@Value("${userId}")
String userId;


//home page
@RequestMapping("/")
private ModelAndView showHome() {
	ModelAndView mav = new ModelAndView("index");
	return mav;
}


//WORKPLACE
@RequestMapping(value = "/workplace", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
		//(value = "/", method = RequestMethod.GET, consumes = {"application/json"})
//		, consumer = "application/xml or text/xml", produces = {"application/json"})
private ModelAndView showWorkPlaceData() {
	ModelAndView mav = new ModelAndView("coworkr-data");
	
	// Create a rest template
	RestTemplate restTemplate = new RestTemplate();


	// Set up headers.
			//FIXME: Adding "consumes" to RequestMapping changed error to 'Content Type " not supported"
	HttpHeaders headers = new HttpHeaders();
//	headers.add("Accept", "application/json");
//	headers.add("Accept", "application/xml");
	headers.add("authToken", authToken);
	headers.add("userId", userId);

	
	//NOTE: This may just be the base url, may not be enough information
	//NOTE: Need to take out "?account=" + userId + "?????
	String url = "https://internal-us.coworkr.co/api/workPlaces";

			
	// Make the Request.
			ResponseEntity<WorkPlace> response = restTemplate.exchange(url,
			HttpMethod.GET, new HttpEntity<>(headers),
			WorkPlace.class);
	
	// Extract body from response.
			WorkPlace result = response.getBody();
	
	//add the info to jsp
			mav.addObject("workPlace", result.getName());
	
	return mav;
}


//FLOORPLAN
//NOTE: won't accept 'consumes = MediaType.TEXT_PLAIN'!!
@RequestMapping(value = "/floorplan", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
		//(value = "/", method = RequestMethod.GET, consumes = {"application/json"})
//		, consumer = "application/xml or text/xml", produces = {"application/json"})
private ModelAndView showFloorPlanData() {
	ModelAndView mav = new ModelAndView("floorplan");
	
	// Create a rest template
	RestTemplate restTemplate = new RestTemplate();


	// Set up headers.
	HttpHeaders headers = new HttpHeaders();
	headers.set("authToken", authToken);
	headers.set("userId", userId);
//	headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
//	headers.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
	headers.setContentType(MediaType.APPLICATION_JSON);

	//Define url
	String url = "https://internal-us.coworkr.co/api/workPlace/gMGkJyMzxQZcoD9ed/floorPlans";

	// Make the Request.
//NOTE: DO I NEED TO ADD "CONTENT TYPE" HERE???
			ResponseEntity<FloorPlan> response = restTemplate.exchange(url,
			HttpMethod.GET, new HttpEntity<>(headers),
			FloorPlan.class);
	
	// Extract body from response.
			FloorPlan result = response.getBody();
	
	//add the info to jsp
			mav.addObject("floorPlanName", result.getName());
	
	return mav;
}




}
