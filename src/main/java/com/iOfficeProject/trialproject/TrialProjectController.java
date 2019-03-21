package com.iOfficeProject.trialproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.iOfficeProject.trialproject.APIclasses.WorkPlace;

@Controller
public class TrialProjectController {
	
@Value("${authToken}")
String authToken;

@Value("${userId}")
String userId;


//@RequestMapping(value = "/test",consumer ="application/xml or text/xml", produces = {"application/json"})

@RequestMapping(value = "/", method = RequestMethod.GET, consumes ="application/json")
		//(value = "/", method = RequestMethod.GET, consumes = {"application/json"})
//		, consumer = "application/xml or text/xml", produces = {"application/json"})
private ModelAndView showInfo() {
	ModelAndView mav = new ModelAndView("coworkr-data");
	
	// Create a rest template
	RestTemplate restTemplate = new RestTemplate();


	// Set up headers.
	//Tell application to accept json //FIXME: currently receiving error "Invalid mime type "text": does not contain '/'"
			//FIXME: Adding "consumes" to RequestMapping changed error to 'Content Type " not supported"
	HttpHeaders headers = new HttpHeaders();
	headers.add("Accept", "application/json");
//	headers.add("Accept", "text/plain");
	headers.add("Accept", "application/xml");
//	headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
//	headers.add(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());
	headers.add("authToken", authToken);
	headers.add("userId", userId);

	
	//NOTE: This may just be the base url, may not be enough information
	String url = "https://internal-us.coworkr.co/api/?account=" +userId + "/api";

			
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

}
