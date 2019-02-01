package com.mycompany.cucoda.sevice;


import com.mycompany.cucoda.model.Address;
import com.mycompany.cucoda.model.AddressId;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.repository.AddressDataRepository;
import com.mycompany.cucoda.service.AddressDataService;

import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class AddressDataServiceBean implements AddressDataService {


    private static final Logger LOG = Logger.getLogger(AddressDataServiceBean.class.getName());

    @EJB
    private AddressDataRepository repository;


    private AddressId generateAddressId() {
        return new AddressId(new Integer(new Random().nextInt()).toString());
    }


    @Override
    public AddressId createAddress(Address address, CustomerNumber customerNumber) {

        LOG.debug("");

        address.setId(generateAddressId());

        repository.createAddress(customerNumber, address);

        return null;
    }

    @Override
    public Address getAddresses(CustomerNumber customerNumber) {
        return null;
    }

    @Override
    public Address getAddress(String addressId) {
        return null;
    }

    @Override
    public void updateAddress(Address address, CustomerNumber customerNumber) {

    }

    @Override
    public void deleteAddress(AddressId addressId, CustomerNumber customerNumber) {

    }

}
