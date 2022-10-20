package org.infatlan.personalizador.repositories;

import java.util.List;

import org.infatlan.personalizador.entities.COUNTRY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface COUNTRY_Repository extends JpaRepository<COUNTRY, Integer>{
    @Query(value = "SELECT * FROM COUNTRY", nativeQuery = true)
    List<COUNTRY> getCOUNTRY();
}
