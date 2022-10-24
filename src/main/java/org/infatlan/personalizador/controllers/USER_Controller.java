package org.infatlan.personalizador.controllers;

import java.util.Map;

import org.infatlan.personalizador.entities.USER;
import org.infatlan.personalizador.service.USER_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")

public class USER_Controller {

    @Autowired
    USER_Service user_service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUsers(@RequestHeader Map<String, String> headers) {
        Map<String, Object> response = user_service.getUsers();
        return ResponseEntity
                .status(Integer.parseInt((String) response.get("Status")))
                .body(response.get("Object"));
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> createValores(@RequestBody USER user,
        @RequestHeader Map<String, String> headers) {
          Map<String, Object> response = user_service.createUsers(user);
      return ResponseEntity.status(Integer.parseInt((String) response.get("Status"))).body(response);

    }
    
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateValores(@RequestBody USER user,
        @RequestHeader Map<String, String> headers) {
          Map<String, Object> response = user_service.createUsers(user);
      return ResponseEntity.status(Integer.parseInt((String) response.get("Status"))).body(response);

    }


}
