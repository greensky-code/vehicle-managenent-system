package com.vehicle;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.vehicle.model.Company;
import com.vehicle.model.Station;
import com.vehicle.model.VehicleDto;
import com.vehicle.repository.CompanyRepository;
import com.vehicle.repository.StationRepository;
import com.vehicle.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleControllerTest {

	@Autowired
	private VehicleService vehicleService;

	@MockBean
	private CompanyRepository companyRepository;

	@MockBean
	private StationRepository stationRepository;


	@Test
	public void getCompanyTest() {
		Mockito.when(companyRepository.findAll()).thenReturn(Stream
				.of(new Company("1", "1", "company 1"), new Company("2", "1", "company 2")).collect(Collectors.toList()));
		assertEquals(2, companyRepository.findAll().size());
	}

	@Test
	public void getStaionTest() {
		Mockito.when(stationRepository.findAll()).thenReturn(Stream
				.of(new Station("1", "23.44556", "55.44556", "station 1", "1"), 
						new Station("2", "55.6655", "67.8855", "station 2", "1"))
				.collect(Collectors.toList()));
		assertEquals(2, stationRepository.findAll().size());
	}

	@Test
	public void saveCompanyTest() {
		Company company = new Company("1", "1", "company 1");
		Mockito.when(companyRepository.save(company)).thenReturn(company);
		assertEquals(company, companyRepository.save(company));
	}

	@Test
	public void findStationLatLonTest() {
		List<Station> stationList = Arrays.asList(new Station("1", "23.44556", "55.44556", "station 1", "1"), 
				new Station("2", "55.6655", "67.8855", "station 2", "1"));
		Mockito.when(vehicleService.findAllStationsWithLatLong("40", "22.34456", "12.5432"))
		.thenReturn(new VehicleDto<List<Station>>(stationList, HttpStatus.OK));
		Mockito.when(stationRepository.findAll())
		.thenReturn(stationList);
		assertEquals(stationList, vehicleService.findAllStationsWithLatLong("40", "22.34456", "12.5432"));
	}

	@Test
	public void saveStationTest() {
		Station station = new Station("1", "23.44556", "55.44556", "station 1", "1");
		Mockito.when(stationRepository.save(station)).thenReturn(station);
		assertEquals(station, stationRepository.save(station));
	}

	@Test
	public void deleteStationTest() {
		Station station = new Station("1", "23.44556", "55.44556", "station 1", "1");
		stationRepository.delete(station);
		Mockito.verify(stationRepository, Mockito.times(1)).delete(station);
	}

	@Test
	public void deleteCompanyTest() {
		Company company = new Company("1", "1", "company 1");
		companyRepository.delete(company);
		Mockito.verify(companyRepository, Mockito.times(1)).delete(company);
	}

}
