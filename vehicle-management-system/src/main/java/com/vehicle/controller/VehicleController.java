package com.vehicle.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.exception.ResourceNotFoundException;
import com.vehicle.model.Company;
import com.vehicle.model.Station;
import com.vehicle.model.VehicleDto;
import com.vehicle.repository.CompanyRepository;
import com.vehicle.repository.StationRepository;
import com.vehicle.service.VehicleService;

@RestController
@RequestMapping(value="/v1/app")
public class VehicleController {

	private final CompanyRepository companyRepo;

	private final StationRepository stationRepo;

	private final VehicleService vehicleService;

	public VehicleController(CompanyRepository companyRepo, StationRepository stationRepo, VehicleService vehicleService) {
		this.companyRepo = companyRepo;
		this.stationRepo = stationRepo;
		this.vehicleService = vehicleService;
	}

	/**
	 * find all stations by company id
	 * @param companyId
	 * @return
	 */
	@GetMapping("/stations/{companyId}")
	public List<Station> findAllStations(@PathVariable String companyId) {
		return stationRepo.findByCompanyId(companyId)
				.orElseThrow(() -> new ResourceNotFoundException("company Id not found " + companyId));
	}

	/**
	 * Get all stations within a radius and from current location
	 * @param radius
	 * @param lat
	 * @param lon
	 * @return
	 */
	@GetMapping("/stations/{radius}/{lat}/{lon}")
	public ResponseEntity<VehicleDto<List<Station>>> findAllStationWithLocation(@PathVariable String radius,
			@PathVariable String lat, @PathVariable String lon) {
		VehicleDto<List<Station>> response = vehicleService.findAllStationsWithLatLong(radius, lat, lon);
		return ResponseEntity.ok(response);
	}

	/**
	 * Return all companies
	 * @return
	 */
	@GetMapping("/companies")
	public List<Company> findAllCompany() {
		return companyRepo.findAll();
	}
	
	/**
	 * Return all stations
	 * @return
	 */
	@GetMapping("/stations")
	public List<Company> findAllStation() {
		return companyRepo.findAll();
	}

	/**
	 * Add a company details
	 * @param company
	 * @return
	 */
	@PostMapping("/company")
	public Company addCompany(@RequestBody Company company) {
		return companyRepo.save(company);
	}

	/**
	 * Add a station details
	 * @param station
	 * @return
	 */
	@PostMapping("/station")
	public Station addStation(@RequestBody Station station) {
		return stationRepo.save(station);
	}

	/**
	 * Update company details with respect to company Id.
	 * Throw exception if not match id 
	 * @param companyRequest
	 * @return
	 */
	@PutMapping("/company/{companyId}")
	public Company updateCompany(@RequestBody Company companyRequest) {
		return companyRepo.findById(companyRequest.getId())
				.map(company -> {
					company.setName(companyRequest.getName());
					company.setParentCompanyId(companyRequest.getParentCompanyId());
					return companyRepo.save(company);
				}).orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + companyRequest.getId()));
	}
	
	/**
	 * Update station details with respect to station Id.
	 * Throw exception if not match id
	 * @param stationRequest
	 * @return
	 */
	@PutMapping("/station/{stationId}")
	public Station updateStation(@RequestBody Station stationRequest) {
		return stationRepo.findById(stationRequest.getId())
				.map(station -> {
					station.setCompanyId(stationRequest.getCompanyId());
					station.setLatitude(stationRequest.getLatitude());
					station.setLongitude(stationRequest.getLongitude());
					station.setName(stationRequest.getName());
					return stationRepo.save(station);
				}).orElseThrow(() -> new ResourceNotFoundException("Station not found with id " + stationRequest.getId()));
	}
		
	/**
	 *  Delete company details with id
	 * @param companyId
	 * @return
	 */
    @DeleteMapping("/company/{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable String companyId) {
        return companyRepo.findById(companyId)
                .map(company -> {
                	companyRepo.delete(company);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Company not found with id " + companyId));
    }
    
    /**
     * Delete station details with id
     * @param stationId
     * @return
     */
    @DeleteMapping("/station/{stationId}")
    public ResponseEntity<?> deleteStation(@PathVariable String stationId) {
        return stationRepo.findById(stationId)
                .map(station -> {
                	stationRepo.delete(station);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("station not found with id " + stationId));
    }
}