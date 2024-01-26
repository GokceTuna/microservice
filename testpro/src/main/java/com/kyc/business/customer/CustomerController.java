package com.kyc.business.customer;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyc.business.WrappedResponse;
import com.kyc.business.account.Account;
import com.kyc.business.account.AccountRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository mOBCustomerRepository;

	@Autowired
	private AccountRepository mOBAccountRepository;

	@PostMapping("/findAll")
	public WrappedResponse index() {
		List<Customer> customers = (List<Customer>) mOBCustomerRepository.findAll();
		for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
			Customer customer = (Customer) iterator.next();
			customer.setAccounts((List<Account>) mOBAccountRepository.findAll());
		}

		WrappedResponse response = new WrappedResponse();
		response.setList(customers);
		return response;
	}

}
