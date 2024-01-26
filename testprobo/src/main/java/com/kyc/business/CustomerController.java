package com.kyc.business;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController extends BaseController {

	@GetMapping("/")
	public Object index() {

		ParameterizedTypeReference<WrappedResponse<Customer>> parameterizedTypeReference = new ParameterizedTypeReference<WrappedResponse<Customer>>() {
		};

		ResponseEntity<WrappedResponse<Customer>> response = call(parameterizedTypeReference);

		WrappedResponse<Customer> lOBCustomer = (WrappedResponse<Customer>) response.getBody();
		return lOBCustomer;
	}

}
