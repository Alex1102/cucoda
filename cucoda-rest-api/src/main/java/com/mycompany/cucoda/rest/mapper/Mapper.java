package com.mycompany.cucoda.rest.mapper;



import com.mycompany.cucoda.rest.model.Address;
import com.mycompany.cucoda.rest.model.AddressId;
import com.mycompany.cucoda.rest.model.Customer;
import com.mycompany.cucoda.rest.model.CustomerNumber;

public class Mapper {

	public static Address mapAddress(com.mycompany.cucoda.model.Address address) {
		return new Address(
				mapAddressId(address.getId()),
				address.getStreet(),
				address.getHouseNumber(),
				address.getZipCode(),
				address.getCity(),
				mapCustomerNumber(address.getCustomerNumber()));
	}

	public static CustomerNumber mapCustomerNumber(com.mycompany.cucoda.model.CustomerNumber customerNumber) {
		return new CustomerNumber(customerNumber.getId());
	}

	public static AddressId mapAddressId(com.mycompany.cucoda.model.AddressId addressId) {
		return new com.mycompany.cucoda.rest.model.AddressId(addressId.getId());
	}

	public static Customer mapCustomer(com.mycompany.cucoda.model.Customer customer) {
		return new Customer(mapCustomerNumber(customer.getCustomerNumber()), customer.getMarketId());
	}
}
