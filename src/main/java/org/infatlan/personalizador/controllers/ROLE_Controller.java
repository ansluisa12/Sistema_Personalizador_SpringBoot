package org.infatlan.personalizador.controllers;

import java.util.Map;

import org.infatlan.personalizador.service.ROLE_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "role")
public class ROLE_Controller {
	
	 @Autowired
	 ROLE_Service role_service;
	 
	 @RequestMapping(
			    value = "",
			    method = RequestMethod.GET,
			    produces = "application/json"
			  )
			  
			  public ResponseEntity<?> getROLE(@RequestHeader Map<String, String> headers) {
			    Map<String, Object> response = role_service.getROLE();
			    return ResponseEntity
			      .status(Integer.parseInt((String) response.get("Status")))
			      .body(response.get(""));
			  }

}
