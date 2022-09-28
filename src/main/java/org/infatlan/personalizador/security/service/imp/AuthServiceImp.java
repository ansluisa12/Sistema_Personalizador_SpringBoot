package org.infatlan.personalizador.security.service.imp;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.infatlan.personalizador.repositories.USER_Repository;
import org.infatlan.personalizador.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.Profiles;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Service
public class AuthServiceImp implements AuthService{

    @Autowired
    USER_Repository usersRepository; 

    @Override
    public boolean validateAD(String username, String password) {
    	if(usersRepository.getInfoByUserName(username).isEmpty()) {
        	return false;
        }else {        	
        	return true;
        }
    	
    }
    

    @Override
    public boolean validateInfo(String username) {
        return false;
    }

    @Override
    public String[] getInfo(String username) {
       
    	try{
    		
            return usersRepository.getInfoByUserName(username).get().split(",");
            
        }catch(NoSuchElementException e){
        	return null;  
        }
    	
    }


}
