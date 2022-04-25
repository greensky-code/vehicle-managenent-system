package com.vehicle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vehicle.model.Station;
import com.vehicle.model.VehicleDto;
import com.vehicle.repository.StationRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	
    private final StationRepository stationRepository;

    public VehicleServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
	
    /**
     * Find all station with lat lon(current location) and radius within
     */
	public VehicleDto<List<Station>> findAllStationsWithLatLong(String radius, String lat, String lon) {
		List<Station> withinStaion = new ArrayList<Station>();
		List<Station> stations = stationRepository.findAll();
		for(Station station : stations) {
			double distance = 6371 * Math.acos(
			        Math.sin(Double.valueOf(station.getLatitude())) * Math.sin(Double.valueOf(lat))
			        + Math.cos(Double.valueOf(station.getLatitude()))
			        * Math.cos(Double.valueOf(lat)) * Math.cos(Double.valueOf(lon) - Double.valueOf(station.getLongitude())));
			if(distance < Double.valueOf(radius)) {
				withinStaion.add(station);
			}
		}
		
		if(withinStaion.size() > 0) {
			return new VehicleDto<List<Station>>(withinStaion, HttpStatus.OK);
		}
		return new VehicleDto<List<Station>>(withinStaion, HttpStatus.NOT_FOUND);
	}

}
