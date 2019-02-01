package com.mycompany.cucoda.service;


import com.mycompany.cucoda.model.Customer;
import com.mycompany.cucoda.model.CustomerNumber;

public interface CustomerDataService {

	CustomerNumber createCustomer(final String marketId);

	Customer getCustomer(final CustomerNumber customerNumber);

	void updateCustomer(final CustomerNumber customerNumber, final String marketId);

	void deleteCustomer(final CustomerNumber customerNumber);

	Customer findCustomerByCustomerNumberOrThrowsException(CustomerNumber customerNumber);
}
