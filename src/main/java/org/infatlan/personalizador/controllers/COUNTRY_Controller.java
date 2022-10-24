package org.infatlan.personalizador.controllers;

import java.util.Map;

import org.infatlan.personalizador.service.COUNTRY_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "country")

public class COUNTRY_Controller {
    
    @Autowired
    COUNTRY_Service country_service;
    
    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = "application/json"
          )
          
          public ResponseEntity<?> getById(@RequestHeader Map<String, String> headers) {
            Map<String, Object> response = country_service.getCOUNTRY();
            return ResponseEntity
              .status(Integer.parseInt((String) response.get("Status")))
              .body(response.get("Object"));
          }


}
