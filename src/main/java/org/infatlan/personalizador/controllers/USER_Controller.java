package org.infatlan.personalizador.controllers;

import org.infatlan.personalizador.service.USER_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")

public class USER_Controller {

	 @Autowired
	 USER_Service user_service;
}
