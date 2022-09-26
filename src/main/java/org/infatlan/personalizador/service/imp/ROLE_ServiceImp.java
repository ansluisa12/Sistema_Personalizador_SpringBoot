package org.infatlan.personalizador.service.imp;

import java.util.List;
import java.util.Map;

import org.infatlan.personalizador.entities.ROLE;
import org.infatlan.personalizador.repositories.ROLE_Repository;
import org.infatlan.personalizador.service.ROLE_Service;
import org.infatlan.personalizador.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ROLE_ServiceImp implements ROLE_Service {

	@Autowired
	ROLE_Repository role_Repository;
	
	@Override
	public Map<String, Object> getROLE() {
		List<ROLE> advance = role_Repository.getROLE();
		return ResponseUtil.getResponse("200", "OK", advance);
	}

}
