package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.model.Customer;
import com.mycompany.cucoda.model.CustomerNumber;

public interface CustomerDataRepository {

	CustomerNumber createCustomer(final CustomerNumber customerNumber, final String marketId);

	void updateCustomer(final CustomerNumber customerNumber, final String marketId);

	void deleteCustomer(CustomerNumber customerNumber);

	Customer findByCustomerNumber(final CustomerNumber customerNumber);
}
