package org.infatlan.personalizador.security.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import com.medium.article.WebSExecuteResponse;

import org.infatlan.personalizador.client.ArticleClient;
import org.infatlan.personalizador.config.SoapClientConfig;
import org.infatlan.personalizador.entities.COUNTRY;
import org.infatlan.personalizador.entities.USER;
import org.infatlan.personalizador.repositories.USER_Repository;
import org.infatlan.personalizador.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    USER_Repository usersRepository;

    @Override
    public boolean validateAD(String username, String password, String country) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                SoapClientConfig.class);
        ArticleClient articleClient = annotationConfigApplicationContext.getBean(ArticleClient.class);
        WebSExecuteResponse webSExecuteResponse = articleClient.getArticle(username, password);
      
        if (webSExecuteResponse.getBan() == 1) { 
            List<USER> user = usersRepository.checkUserCountry(country, username);
            if(usersRepository.checkUserCountry(country, username).isEmpty()) {
                return false;
            }     
            else {
                return true;
            }
           
        }
        return false;

        // if(usersRepository.getInfoByUserName(username).isEmpty()) {
        // return false;
        // }else {
        // return true;
        // }

    }

    @Override
    public String[] getInfo(String username) {

        try {

            return usersRepository.getInfoByUserName(username).get().split(",");

        } catch (NoSuchElementException e) {
            return null;
        }

    }

}
