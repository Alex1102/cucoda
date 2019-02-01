package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.exception.AddressAlreadyExistsException;
import com.mycompany.cucoda.exception.AddressNotFoundException;
import com.mycompany.cucoda.model.Address;
import com.mycompany.cucoda.model.AddressId;
import com.mycompany.cucoda.model.CustomerNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


@Stateless
public class AddressRepositoryImpl implements AddressDataRepository {


    private static final Logger LOG = Logger.getLogger(AddressRepositoryImpl.class.getName());

    private Map<CustomerNumber, Map<AddressId, Address>> addresses = new HashMap<>();


    @Override
    public AddressId createAddress(final CustomerNumber customerNumber, final Address address) {

        if (findAddressBy(customerNumber, address.getId()) != null) {
            String msg = String.format("Address with addressId %s is already exists", address.getId());
            LOG.error("AddressAlreadyExistsException: " + msg);
            throw new AddressAlreadyExistsException(msg);
        }

        Map<AddressId, Address> customerAddresses = addresses.get(customerNumber);

        if (customerAddresses.isEmpty()) {
            customerAddresses = new HashMap<AddressId, Address>();
        }

        customerAddresses.put(address.getId(), address);
        addresses.put(customerNumber, customerAddresses);

        return address.getId();
    }

    @Override
    public void updateAddress(final CustomerNumber customerNumber, final Address address) {

        Map<AddressId, Address> customerAddresses = addresses.get(customerNumber);
        findAddressBy(customerNumber, address.getId());

        customerAddresses.put(address.getId(), address);
        addresses.put(customerNumber, customerAddresses);
    }

    @Override
    public AddressId deleteAddress(final CustomerNumber customerNumber, final AddressId addressId) {

        Address existingAddress = findAddressBy(customerNumber, addressId);

        Map<AddressId, Address> customerAddresses = addresses.get(customerNumber);
        customerAddresses.remove(existingAddress);

        return addressId;
    }

    @Override
    public Address findAddressBy(final CustomerNumber customerNumber, final AddressId addressId) {

        Map<AddressId, Address> customerAddresses = addresses.get(customerNumber);

        if (customerAddresses.isEmpty()) {
            final String msg = String.format("Could't found any customer address for addressId %s", addressId);
            LOG.error("AddressAlreadyExistsException: " + msg);
        }

        Address existingAddress = customerAddresses.get(addressId);
        if (existingAddress == null) {
            final String msg = String.format("Could't found any customer address for addressId %s", addressId);
            LOG.error("AddressAlreadyExistsException: " + msg);
            throw new AddressNotFoundException(msg);
        }

        return existingAddress;
    }

    @Override
    public List<Address> findAddressesBy(final CustomerNumber customerNumber) {

        Map<AddressId, Address> customerAddresses = addresses.get(customerNumber);

        if (customerAddresses.isEmpty()) {
            final String msg = String.format("Could't found any customer address for customerNumber %s", customerNumber);
            LOG.error("AddressAlreadyExistsException: " + msg);
        }

        return customerAddresses.values().stream()
                .collect(Collectors.toList());
    }

}
