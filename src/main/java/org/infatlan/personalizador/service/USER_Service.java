package org.infatlan.personalizador.service;

import java.util.Map;

import org.infatlan.personalizador.entities.USER;


public interface USER_Service {
    
    public Map<String, Object> getUsers();
    public Map<String, Object> createUsers(USER user);
	
}
