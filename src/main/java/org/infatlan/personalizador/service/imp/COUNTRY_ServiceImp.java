package org.infatlan.personalizador.service.imp;

import java.util.List;
import java.util.Map;

import org.infatlan.personalizador.entities.COUNTRY;
import org.infatlan.personalizador.repositories.COUNTRY_Repository;
import org.infatlan.personalizador.service.COUNTRY_Service;
import org.infatlan.personalizador.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class COUNTRY_ServiceImp  implements COUNTRY_Service{
    
    @Autowired
    COUNTRY_Repository country_repository;

    @Override
    public Map<String, Object> getCOUNTRY() {
        List<COUNTRY> country = country_repository.getCOUNTRY();
        return ResponseUtil.getResponse("200", "OK", country);
    }

}
