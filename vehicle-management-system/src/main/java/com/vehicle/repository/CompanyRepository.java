package com.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}
