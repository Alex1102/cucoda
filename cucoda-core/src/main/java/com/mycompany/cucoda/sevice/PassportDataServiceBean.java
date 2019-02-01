package com.mycompany.cucoda.sevice;


import com.mycompany.cucoda.exception.CustomerNotFoundException;
import com.mycompany.cucoda.exception.PassportAlreadyExistsException;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.model.Passport;
import com.mycompany.cucoda.model.PassportId;
import com.mycompany.cucoda.repository.PassportDataRepository;
import com.mycompany.cucoda.service.CustomerDataService;
import com.mycompany.cucoda.service.PassportDataService;

import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;


@Stateless
public class PassportDataServiceBean implements PassportDataService {


    private static final Logger LOG = Logger.getLogger(AddressDataServiceBean.class.getName());

    @EJB
    private PassportDataRepository repository;
    @EJB
    private CustomerDataService customerDataService;


    @Override
    public PassportId createPassportData(Passport passport, CustomerNumber customerNumber) {

        customerDataService.findCustomerByCustomerNumberOrThrowsException(customerNumber);

        Passport existingPassport = repository.findPassportDataBy(customerNumber, passport.getId());
        if (existingPassport != null) {
            final String msg = String.format("The Customer %s has already been persisted and can not be persisted again."
                    , customerNumber.toString());
            LOG.error("PassportAlreadyExistsException: " + msg);
            throw new PassportAlreadyExistsException(msg);
        }

        final PassportId generatePassportId = generatePassportId();

        return repository.createPassportData(customerNumber, passport);
    }

    @Override
    public Passport getPassportData(CustomerNumber customerNumber) {
        return findPassportByCustomerNumberOrThrowsException(customerNumber);
    }

    @Override
    public void updatePassportData(Passport passport, CustomerNumber customerNumber) {
        customerDataService.findCustomerByCustomerNumberOrThrowsException(customerNumber);
        findPassportByCustomerNumberOrThrowsException(customerNumber);
    }

    @Override
    public void deletePassportData(PassportId passportId, CustomerNumber customerNumber) {
        customerDataService.findCustomerByCustomerNumberOrThrowsException(customerNumber);
        findPassportByCustomerNumberAndPassportIdOrThrowsException(passportId, customerNumber);
        deletePassportData(passportId, customerNumber);
    }



    @Override
    public Passport findPassportByCustomerNumberOrThrowsException(CustomerNumber customerNumber) {

        customerDataService.findCustomerByCustomerNumberOrThrowsException(customerNumber);

        final Passport passport = repository.findPassportDataBy(customerNumber);
        if (passport == null) {
            final String msg = String.format("Passport for customer with customer number %s not found", customerNumber);
            LOG.error("CustomerNotFoundException: " + msg);
            throw new CustomerNotFoundException(msg);
        }
        return passport;
    }


    @Override
    public Passport findPassportByCustomerNumberAndPassportIdOrThrowsException(PassportId passportId, CustomerNumber customerNumber) {

        customerDataService.findCustomerByCustomerNumberOrThrowsException(customerNumber);

        final Passport passport = repository.findPassportDataBy(customerNumber, passportId);
        if (passport == null) {
            final String msg = String.format("Passport for customer with customer number %s not found", customerNumber);
            LOG.error("CustomerNotFoundException: " + msg);
            throw new CustomerNotFoundException(msg);
        }
        return passport;
    }


    private PassportId generatePassportId() {
        return new PassportId(new Integer(new Random().nextInt()).toString());
    }

}
