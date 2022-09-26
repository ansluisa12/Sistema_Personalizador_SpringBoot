package org.infatlan.personalizador.repositories;

import java.util.List;

import org.infatlan.personalizador.entities.ROLE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ROLE_Repository extends JpaRepository<ROLE, Integer> {

	@Query(value = "SELECT * FROM ROLE", nativeQuery = true)
	List<ROLE> getROLE();
}
