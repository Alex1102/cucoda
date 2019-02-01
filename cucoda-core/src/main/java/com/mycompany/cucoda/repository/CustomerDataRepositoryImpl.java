package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.model.Customer;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.model.Market;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class CustomerDataRepositoryImpl implements CustomerDataRepository {

//    @Resource(mappedName = "java:jboss/datasources/CarlosMigraeneDS")
//    DataSource ds;

    private Map<CustomerNumber, Customer> customers = new HashMap<>();

    @PostConstruct
    void init() {
        customers.put(new CustomerNumber("1"), new Customer( new CustomerNumber("1"), Market.MY_COMPANY.getId()));
        customers.put(new CustomerNumber("2"), new Customer( new CustomerNumber("2"), Market.MY_COMPANY.getId()));
    }


    @Override
    public Customer findByCustomerNumber(final CustomerNumber customerNumber) {
        return customers.get(customerNumber);
    }

    @Override
    public CustomerNumber createCustomer(final CustomerNumber customerNumber, final String marketId) {

//        customers.put("3", new Customer( "1","test", "test", "test@google.mail"));

        // final String marketId, final Date validFrom
        final Customer customer = new Customer(customerNumber, marketId);
        customers.put(customerNumber, customer);

        return customer.getCustomerNumber();
    }

    @Override
    public void updateCustomer(final CustomerNumber customerNumber, final String marketId) {
        Customer customer = findByCustomerNumber(customerNumber);
        customer.setMarketId(marketId);
        customers.put(customerNumber, customer);
    }


    @Override
    public void deleteCustomer(CustomerNumber customerNumber) {

        Customer customer = customers.get(customerNumber);
        if (customer == null) {
            throw new EntityNotFoundException(String.format("Customer with customer number %s not found", customerNumber));
        }

        customers.remove(customer);
    }

}
