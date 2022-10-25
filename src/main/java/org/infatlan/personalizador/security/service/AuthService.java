package org.infatlan.personalizador.security.service;

public interface AuthService {

    boolean validateAD(String username, String password, String country);
    String[] getInfo(String username);

}
