package org.infatlan.personalizador.service.imp;


import java.util.List;
import java.util.Map;

import org.infatlan.personalizador.entities.REGION;
import org.infatlan.personalizador.entities.USER;
import org.infatlan.personalizador.repositories.REGION_Repository;
import org.infatlan.personalizador.repositories.USER_Repository;
import org.infatlan.personalizador.service.REGION_Service;
import org.infatlan.personalizador.service.USER_Service;
import org.infatlan.personalizador.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



@Service
public class REGION_ServiceImp implements REGION_Service{

	@Autowired
	REGION_Repository REGION_Repository;
	
	@Override
	public Map<String, Object> getRegion(){
	    List<REGION> region = REGION_Repository.getRegion(); //user_Repository.getUsers();
        return ResponseUtil.getResponse("200", "OK", region);
	}

	@Override
	public Map<String, Object> createRegion(REGION region) {
		 try {
	        //  CrudRepository<REGION, Integer> REGION_Repository;
			REGION_Repository.save(region);
	           } catch (Exception e) {
	               return ResponseUtil.getResponse("400", "Algo salio mal");
	           }
	    
	       return ResponseUtil.getResponse("200", "OK");
	}


	

}