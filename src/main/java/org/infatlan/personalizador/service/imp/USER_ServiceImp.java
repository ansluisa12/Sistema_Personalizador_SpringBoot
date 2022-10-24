package org.infatlan.personalizador.service.imp;


import java.util.List;
import java.util.Map;

import org.infatlan.personalizador.entities.USER;
import org.infatlan.personalizador.repositories.USER_Repository;
import org.infatlan.personalizador.service.USER_Service;
import org.infatlan.personalizador.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class USER_ServiceImp implements USER_Service{
 
	@Autowired
	USER_Repository user_Repository;

    @Override
    public Map<String, Object> getUsers() {
        List<USER> user = user_Repository.getUsers();
        return ResponseUtil.getResponse("200", "OK", user);
    }

    @Override
    public Map<String, Object> createUsers(USER user) {
        try {
            user_Repository.save(user);
           } catch (Exception e) {
               return ResponseUtil.getResponse("400", "Algo salio mal");
           }
    
       return ResponseUtil.getResponse("200", "OK");
    }


}
