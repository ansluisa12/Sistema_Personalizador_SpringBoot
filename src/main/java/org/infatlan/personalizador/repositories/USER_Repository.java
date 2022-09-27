package org.infatlan.personalizador.repositories;

import org.infatlan.personalizador.entities.USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface USER_Repository extends JpaRepository<USER, Integer> {
	
	@Query("SELECT U FROM USER U WHERE USERNAME = ?1")
	public USER findByUserName(String USERNAME);

}
