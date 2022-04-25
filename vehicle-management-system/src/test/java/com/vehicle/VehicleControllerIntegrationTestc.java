package com.vehicle;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vehicle.controller.VehicleController;
import com.vehicle.model.Company;
import com.vehicle.repository.CompanyRepository;
import com.vehicle.repository.StationRepository;
import com.vehicle.service.VehicleService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleController.class)
public class VehicleControllerIntegrationTestc {
	
	@MockBean
	private CompanyRepository companyRepository;
	
	@MockBean
	private StationRepository stationRepository;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createcompanyTest() throws Exception {
		String exampleCompanyJson = "{\"id\":\"1\",\"parentCompanyId\":\"1\",\"name\":\"company 1\"}";

		Company company = new Company("1", "1", "company 1");
		Mockito.when(
				companyRepository.save(Mockito.any())).thenReturn(company);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/v1/app/company")
				.accept(MediaType.APPLICATION_JSON).content(exampleCompanyJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
}
