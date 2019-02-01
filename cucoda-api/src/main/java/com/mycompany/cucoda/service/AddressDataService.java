package com.mycompany.cucoda.service;


import com.mycompany.cucoda.model.Address;
import com.mycompany.cucoda.model.AddressId;
import com.mycompany.cucoda.model.CustomerNumber;

public interface AddressDataService {

	AddressId createAddress(final Address address, final CustomerNumber customerNumber);

	Address getAddresses(final CustomerNumber customerNumber);

	Address getAddress(final String addressId);

	void updateAddress(final Address address, final CustomerNumber customerNumber);

	void deleteAddress(final AddressId addressId, final CustomerNumber customerNumber);
}
