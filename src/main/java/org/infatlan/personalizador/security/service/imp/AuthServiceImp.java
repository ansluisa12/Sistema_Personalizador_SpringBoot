package org.infatlan.personalizador.security.service.imp;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.infatlan.personalizador.repositories.USER_Repository;
import org.infatlan.personalizador.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AuthServiceImp implements AuthService {

	@Autowired
	USER_Repository user_Repository;

	@Override
	public boolean validateAD(String username, String password) {
		if (user_Repository.findByUserName(username) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean validateInfo(String email) {
		return false;
	}

	@Override
	public String[] getInfo(String username) {

		try {
			return user_Repository.getInfoByUserName(username).get().split(",");
		} catch (NoSuchElementException e) {
			return null;
		}

	}

}
