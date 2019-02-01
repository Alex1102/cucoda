package com.mycompany.cucoda.sevice;


import com.mycompany.cucoda.exception.CustomerAlreadyExistsException;
import com.mycompany.cucoda.exception.CustomerNotFoundException;
import com.mycompany.cucoda.exception.InvalidArgumentException;
import com.mycompany.cucoda.model.Customer;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.model.Market;
import com.mycompany.cucoda.repository.CustomerDataRepository;
import com.mycompany.cucoda.service.CustomerDataService;

import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless
public class CustomerDataServiceBean implements CustomerDataService {


    private static final Logger LOG = Logger.getLogger(CustomerDataServiceBean.class.getName());

    @EJB
    private CustomerDataRepository repository;


    @Override
    public CustomerNumber createCustomer(final String marketId) {

        findMarketByIdOrThrowsException(marketId);

        final CustomerNumber customerNumber = generateCustomerNumber();

        final Customer customer = repository.findByCustomerNumber(customerNumber);
        if (customer != null) {
            final String msg = String.format("The Customer %s has already been persisted and must not be persisted again."
                    , customerNumber.toString());
            LOG.error("CustomerAlreadyExistsException: " + msg);
            throw new CustomerAlreadyExistsException(msg);
        }

        return repository.createCustomer(customerNumber, marketId);
    }

    @Override
    public Customer getCustomer(final CustomerNumber customerNumber) {
        return findCustomerByCustomerNumberOrThrowsException(customerNumber);
    }

    @Override
    public void updateCustomer(final CustomerNumber customerNumber, final String marketId) {

        findMarketByIdOrThrowsException(marketId);
        findCustomerByCustomerNumberOrThrowsException(customerNumber);

        repository.updateCustomer(customerNumber, marketId);
    }

    @Override
    public void deleteCustomer(CustomerNumber customerNumber) {
        findCustomerByCustomerNumberOrThrowsException(customerNumber);
        repository.deleteCustomer(customerNumber);
    }


    private void findMarketByIdOrThrowsException(String marketId) {
        if (! Market.hasMarket(marketId)) {
            final String msg = String.format("Could not found market for marketId %s", marketId);
            LOG.debug(msg);
            throw new InvalidArgumentException(marketId);
        }
    }

    public Customer findCustomerByCustomerNumberOrThrowsException(CustomerNumber customerNumber) {
        final Customer customer = repository.findByCustomerNumber(customerNumber);
        if (customer == null) {
            final String msg = String.format("Customer with customer number %s not found", customerNumber);
            LOG.error("CustomerNotFoundException: " + msg);
            throw new CustomerNotFoundException(msg);
        }
        return customer;
    }

    private CustomerNumber generateCustomerNumber() {
        return new CustomerNumber(new Integer(new Random().nextInt()).toString());
    }

}
