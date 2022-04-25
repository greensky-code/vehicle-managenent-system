package com.vehicle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicle.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, String> {
	
	@Query("SELECT u FROM Station u WHERE u.companyId = :companyId")
	public Optional<List<Station>> findByCompanyId(@Param("companyId") String companyId);

}
