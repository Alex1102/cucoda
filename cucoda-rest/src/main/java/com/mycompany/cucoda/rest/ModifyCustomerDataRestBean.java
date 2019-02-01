package com.mycompany.cucoda.rest;

import static com.mycompany.cucoda.rest.util.RestValidationUtils.*;

import com.mycompany.cucoda.exception.InvalidCustomerException;
import com.mycompany.cucoda.model.*;
import com.mycompany.cucoda.repository.AddressRepositoryImpl;
import com.mycompany.cucoda.rest.api.ModifyCustomerDataRestService;
import com.mycompany.cucoda.rest.mapper.Mapper;
import com.mycompany.cucoda.rest.util.Authorizations;
import com.mycompany.cucoda.service.AddressDataService;
import com.mycompany.cucoda.service.CustomerDataService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.HttpResponse;

import java.util.HashMap;
import java.util.Map;


@Path("/")
public class ModifyCustomerDataRestBean implements ModifyCustomerDataRestService {


    private static final Logger LOG = Logger.getLogger(ModifyCustomerDataRestBean.class.getName());

	@Context
	private HttpResponse response;
	@EJB
	private CustomerDataService customerDataService;
	@EJB
    private AddressDataService addressDataService;



    // ************** Customer ***************

	@RolesAllowed(value = {Authorizations.WRITE_ROLE})
	@Override
	public Response createCustomer(final String marketId) {

        validateAllParametersAreNotNullOrEmpty(marketId);

        CustomerNumber customerNumber;

		try {
			customerNumber = customerDataService.createCustomer(marketId);
		} catch (final InvalidCustomerException e) {
            throw new WebApplicationException(
                    Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(String.format("Something went terribly wrong at customer creation"))
                    .build());
		}

        if (customerNumber != null && customerNumber.getId() != null) {
            return Response
                    .status(Response.Status.CREATED.getStatusCode())
                    .entity(Mapper.mapCustomerNumber(customerNumber))
                    .build();
        } else {
            throw new WebApplicationException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(String.format("Something went terribly wrong at customer creation"))
                    .build());
        }
	}

    @RolesAllowed(value = {Authorizations.WRITE_ROLE})
    @Override
    public Response updateCustomer(final String customerNumber, final String marketId) {

        validateNotNullOrEmptyParameter(customerNumber, "customerNumber");
        validateNotNullOrEmptyParameter(marketId, "marketId");

        customerDataService.updateCustomer(new CustomerNumber(customerNumber), marketId);

        return Response
                .status(Response.Status.OK.getStatusCode())
                .entity(String.format("Customer with customer number %s was updated", customerNumber))
                .build();
    }

    @RolesAllowed(value = {Authorizations.WRITE_ROLE})
    @Override
    public Response deleteCustomer(final String customerNumber) {

        validateAllParametersAreNotNullOrEmpty(customerNumber);

        customerDataService.deleteCustomer(new CustomerNumber(customerNumber));

        return Response
                .status(Response.Status.OK.getStatusCode())
                .entity(String.format("Customer with customer number %s was deleted", customerNumber))
                .build();
    }



    // ************** Address ***************

    @Override
    public Response createAddress(String customerNumber, Address address) {

        validateNotNullOrEmptyParameter(customerNumber, "customerNumber");
        validateNotNullParameter(address);

        addressDataService.createAddress(address, new CustomerNumber(customerNumber));
        return Response
                .status(Response.Status.CREATED.getStatusCode()).entity(customerNumber).build();
    }

    @Override
    public Response updateAddress(String customerNumber, Address address) {

        validateNotNullOrEmptyParameter(customerNumber, "customerNumber");
        validateNotNullParameter(address);

        addressDataService.updateAddress(address, new CustomerNumber(customerNumber));
        return Response
                .status(Response.Status.OK.getStatusCode())
                .entity(String.format("Address for Customer with customer number %s was updated", customerNumber))
                .build();
    }

    @Override
    public Response deleteAddress(String customerNumber, AddressId addressId) {

        validateNotNullOrEmptyParameter(customerNumber, "customerNumber");
        validateNotNullParameter(addressId);

        addressDataService.deleteAddress(addressId, new CustomerNumber(customerNumber));

        return Response
                .status(Response.Status.OK.getStatusCode())
                .entity(String.format("Address for Customer with customer number %s was deleted", customerNumber))
                .build();
    }



    // ************** Passport ***************

    @Override
    public Response createPassport(String customerNumber, Passport passport) {
        return null;
    }

    @Override
    public Response updatePassport(String customerNumber, Passport passport) {
        return null;
    }

    @Override
    public Response deletePassport(String customerNumber, PassportId passportId) {
        return null;
    }



    // ************** Payment ***************


    @Override
    public Response createPayment(String customerNumber, Payment passport) {
        return null;
    }

    @Override
    public Response updatePayment(String customerNumber, Payment payment) {
        return null;
    }

    @Override
    public Response deletePayment(String customerNumber, PaymentId paymentId) {
        return null;
    }



    // ************** Contact ***************

    @Override
    public Response createContact(String customerNumber, Contact contact) {
        return null;
    }

    @Override
    public Response updateContact(String customerNumber, Contact contact) {
        return null;
    }

    @Override
    public Response deleteContact(String customerNumber, ContactId contactId) {
        return null;
    }

}

