package org.infatlan.personalizador.repositories;

import java.util.List;
import java.util.Optional;

import org.infatlan.personalizador.entities.REGION;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface REGION_Repository extends JpaRepository<REGION, Integer>{
	@Query("SELECT U FROM REGION U WHERE NAME = ?1")
	public REGION findByUserName(String NAME);
	
	 @Query("SELECT U FROM REGION U")
	 List<REGION> getRegion();
	
	@Query(value = "SELECT "
	        + "r.NAME, "
	        + "u.REGION_CODE, "
	        + "u.DESCRIPTION, "
	        + "u.STATUS, "
	        + "FROM [REGION] u "
			+ "WHERE u.NAME = :regionname", nativeQuery = true)
	Optional<String> getInfoByRegionName(@Param("regionname") String regionname);
	
	@Query("SELECT U.REGION_CODE, U.NAME FROM REGION U WHERE NAME = ?1")
	Optional<String> findInfoByRegionName(String REGIONNAME);

}
