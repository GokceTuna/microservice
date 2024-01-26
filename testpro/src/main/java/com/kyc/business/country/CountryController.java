package com.kyc.business.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import com.kyc.business.WrappedResponse;

@RestController
public class CountryController {

	@Autowired
	private CountryClient countryClient;
	
	public CountryController() {
		// TODO Auto-generated constructor stub
	}

	
	@GetMapping("/findByName")
	public WrappedResponse findByName(@RequestParam String country) {
		
		GetCountryResponse lOBGetCountryResponse = countryClient.getCountry(country);
		

		WrappedResponse response = new WrappedResponse();
		response.getList().add(lOBGetCountryResponse.getCountry());
		return response;
	}

	@GetMapping("/find")
	public WrappedResponse find() {
		
		GetCountryResponse lOBGetCountryResponse = countryClient.getCountry("Spain");
		

		WrappedResponse response = new WrappedResponse();
		response.getList().add(lOBGetCountryResponse.getCountry());
		return response;
	}
}
