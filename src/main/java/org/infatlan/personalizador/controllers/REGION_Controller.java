package org.infatlan.personalizador.controllers;

import java.util.Map;

import org.infatlan.personalizador.entities.REGION;
import org.infatlan.personalizador.service.REGION_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "region")

public class REGION_Controller {

    @Autowired
    REGION_Service region_service;

   //test 
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getRegion(@RequestHeader Map<String, String> headers) {
        Map<String, Object> response = region_service.getRegion();
        return ResponseEntity
                .status(Integer.parseInt((String) response.get("Status")))
                .body(response.get("Object"));
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> createValores(@RequestBody REGION region,
        @RequestHeader Map<String, String> headers) {
          Map<String, Object> response = region_service.createRegion(region);
      return ResponseEntity.status(Integer.parseInt((String) response.get("Status"))).body(response);

    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateValores(@RequestBody REGION region,
        @RequestHeader Map<String, String> headers) {
          Map<String, Object> response = region_service.createRegion(region);
      return ResponseEntity.status(Integer.parseInt((String) response.get("Status"))).body(response);

    }


}
