package org.infatlan.personalizador.service.imp;


import org.infatlan.personalizador.repositories.USER_Repository;
import org.infatlan.personalizador.service.USER_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class USER_ServiceImp implements USER_Service{

	@Autowired
	USER_Repository user_Repository;

}
