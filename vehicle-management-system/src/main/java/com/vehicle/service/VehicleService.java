package com.vehicle.service;

import java.util.List;

import com.vehicle.model.Station;
import com.vehicle.model.VehicleDto;

public interface VehicleService {
	
	public VehicleDto<List<Station>> findAllStationsWithLatLong(String radius, String lat, String lon);

}
