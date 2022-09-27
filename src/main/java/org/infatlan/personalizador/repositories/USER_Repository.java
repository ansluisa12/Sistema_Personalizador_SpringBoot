package org.infatlan.personalizador.repositories;

import java.util.Optional;

import org.infatlan.personalizador.entities.USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface USER_Repository extends JpaRepository<USER, Integer> {
	
	@Query("SELECT U FROM USER U WHERE USERNAME = ?1")
	public USER findByUserName(String USERNAME);

	@Query(value = "SELECT "
			+ "r.NAME, "
			+ "u.USER_CODE, "
			+ "u.FIRST_NAME, "
			+ "u.LAST_NAME "
			+ "FROM [USER] u "
			+ "JOIN [ROLE] r ON u.ROLE_CODE = r.ROLE_CODE "
			+ "WHERE u.USER_NAME = :username", nativeQuery = true)
	Optional<String> getInfoByUserName(@Param("username") String username);

}
