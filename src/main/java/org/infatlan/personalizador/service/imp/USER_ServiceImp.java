package org.infatlan.personalizador.service.imp;

import java.util.List;
import java.util.Map;

import org.infatlan.personalizador.entities.USER;
import org.infatlan.personalizador.repositories.USER_Repository;
import org.infatlan.personalizador.service.USER_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class USER_ServiceImp implements USER_Service{

	@Autowired
	USER_Repository user_Repository;

}
