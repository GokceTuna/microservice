package com.kyc.business;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class BaseController {

	public BaseController() {
		// TODO Auto-generated constructor stub
	}

	public <T> ResponseEntity<WrappedResponse<T>> call(ParameterizedTypeReference<WrappedResponse<T>> parameterizedTypeReference) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<WrappedResponse<T>> response = restTemplate.exchange("http://localhost:8082/findAll",
				HttpMethod.POST, null, parameterizedTypeReference);
		return response;

	}
}
