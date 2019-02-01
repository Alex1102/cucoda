package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.model.Address;
import com.mycompany.cucoda.model.AddressId;
import com.mycompany.cucoda.model.CustomerNumber;

import java.util.List;

public interface AddressDataRepository {

	AddressId createAddress(final CustomerNumber customerNumber, final Address address);

	void updateAddress(final CustomerNumber customerNumber, final Address address);

	AddressId deleteAddress(final CustomerNumber customerNumber, final AddressId addressId);

	Address findAddressBy(final CustomerNumber customerNumber, final AddressId addressId);

	List<Address> findAddressesBy(final CustomerNumber customerNumber);
}
