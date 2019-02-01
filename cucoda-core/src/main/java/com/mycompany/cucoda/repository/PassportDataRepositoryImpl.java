package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.exception.PassportAlreadyExistsException;
import com.mycompany.cucoda.exception.PassportNotFoundException;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.model.Passport;
import com.mycompany.cucoda.model.PassportId;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


@Stateless
public class PassportDataRepositoryImpl implements PassportDataRepository {


    private static final Logger LOG = Logger.getLogger(PassportDataRepositoryImpl.class.getName());

    private Map<CustomerNumber, Passport> customers = new HashMap<>();


    @Override
    public PassportId createPassportData(CustomerNumber customerNumber, Passport passport) {

        if (findPassportDataBy(customerNumber, passport.getId()) != null) {
            String msg = String.format("Passport with passportId %s is already exists", passport.getId());
            LOG.error("PassportAlreadyExistsException: " + msg);
            throw new PassportAlreadyExistsException(msg);
        }

        customers.put(customerNumber, passport);
        return passport.getId();
    }

    @Override
    public void updatePassportData(CustomerNumber customerNumber, Passport passport) {
        findPassportDataBy(customerNumber, passport.getId());
        customers.put(customerNumber, passport);
    }

    @Override
    public PassportId deletePassportData(CustomerNumber customerNumber, PassportId passportId) {

        findPassportDataBy(customerNumber, passportId);
        customers.remove(customerNumber, passportId);

        return passportId;
    }

    @Override
    public Passport findPassportDataBy(CustomerNumber customerNumber) {

        Passport passport = customers.get(customerNumber);
        if (passport == null) {
            String msg = String.format("Passport for customer with customerNumber %s does not exists", customerNumber);
            LOG.error("PassportNotFoundException: " + msg);
            throw new PassportNotFoundException(msg);
        }

        return passport;
    }

    @Override
    public Passport findPassportDataBy(CustomerNumber customerNumber, PassportId passportId) {

        Passport passport = customers.get(customerNumber);
        if (passport == null) {
            String msg = String.format("Passport with passportId %s does not exists", passportId);
            LOG.error("PassportDataRepositoryImpl: " + msg);
            throw new PassportNotFoundException(msg);
        }

        return passport;
    }


}
