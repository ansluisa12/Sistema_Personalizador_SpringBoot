package org.infatlan.personalizador.repositories;

import java.util.List;
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
	
	@Query(value = "SELECT * FROM PUSERS U WHERE U.COUNTRY_CODE = :COUNTRY_CODE AND U.USER_NAME = :USERNAME",nativeQuery = true)
	List<USER> checkUserCountry(@Param("COUNTRY_CODE")String COUNTRY_CODE, @Param("USERNAME") String USERNAME);
	
	 @Query("SELECT U FROM USER U")
	 List<USER> getUsers();
	
	@Query(value = "SELECT "
	        + "r.NAME, "
	        + "u.USER_CODE, "
	        + "u.FIRST_NAME, "
	        + "u.LAST_NAME, "
	        + "c.NAME as COUNTRY, "
	        + "b.NAME as BRANCH "
	        + "FROM [PUSERS] u "
	        + "JOIN [ROLE] r ON u.ROLE_CODE = r.ROLE_CODE "
	        + "JOIN [COUNTRY] c ON c.COUNTRY_CODE = u.COUNTRY_CODE "
	        + "JOIN [BRANCH] b ON b.BRANCH_CODE = u.BRANCH_CODE "
			+ "WHERE u.USER_NAME = :username", nativeQuery = true)
	Optional<String> getInfoByUserName(@Param("username") String username);
	
	@Query("SELECT U.COUNTRY_CODE, U.BRANCH_CODE FROM USER U WHERE USERNAME = ?1")
	Optional<String> findInfoByUserName(String USERNAME);

}
