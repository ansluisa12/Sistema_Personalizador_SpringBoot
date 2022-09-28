package org.infatlan.personalizador.security.service;

public interface AuthService {

    boolean validateAD(String username, String password);
    boolean validateInfo(String username);
    String[] getInfo(String username);

}
