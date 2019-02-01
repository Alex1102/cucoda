package com.mycompany.cucoda.rest;


import static com.mycompany.cucoda.rest.util.RestValidationUtils.validateAllParametersAreNotNullOrEmpty;

import com.mycompany.cucoda.model.Customer;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.rest.api.ReadCustomerDataRestService;
import com.mycompany.cucoda.rest.mapper.Mapper;
import com.mycompany.cucoda.rest.util.Authorizations;
import com.mycompany.cucoda.service.CustomerDataService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.HttpResponse;


@Path("/")
public class ReadCustomerDataRestBean implements ReadCustomerDataRestService {


    private static final Logger LOG = Logger.getLogger(ReadCustomerDataRestBean.class.getName());

    @Context
    private HttpResponse response;
    @EJB
	private CustomerDataService service;


    @RolesAllowed(value = {Authorizations.READ_ROLE})
	@Override
	public Response getCustomer(final String customerNumber) {

        validateAllParametersAreNotNullOrEmpty(customerNumber);

		final Customer customer = service.getCustomer(new CustomerNumber(customerNumber));

        if (customer != null) {
            return Response
                    .status(Response.Status.CREATED.getStatusCode())
                    .entity(Mapper.mapCustomer(customer))
                    .build();
        } else {
//            LOG.error(String.format("Something went terribly wrong for oneAccountId %s and customerId %s", oneAccountId, customerId));
            throw new WebApplicationException(
                    Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .entity(String.format("Something went terribly wrong for customerNumber %s", customerNumber))
                    .build());
        }
	}

    @Override
    public Response getAddress(String customerNumber) {
        return null;
    }

    @Override
    public Response getPayment(String customerNumber) {
        return null;
    }

    @Override
    public Response getPassport(String customerNumber) {
        return null;
    }

    @Override
    public Response getContact(String customerNumber) {
        return null;
    }


/*
	@Override
	@GET
	@Path("customers/{customerNumber}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Customer getCustomer(final String customerNumber) {

		return new Customer("adfa", "adfas", "asdf", "test@test.com");

//		RestValidationUtils.validateAtLeastOneValidParameter(customerNumber);
//
//		try {
//			return readCustomerDataService.getCustomer(customerNumber);
//		} catch (final IllegalArgumentException e) {
//			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
//					.entity("Illegal argument: " + e.getMessage())
//					.build());
//		} catch (final InvalidCustomerException e) {
////            LOG.debug("Customer with customerNumber: " + customerNumber + " not found, will return HTTP" + Response.Status.BAD_REQUEST.getStatusCode(), e);
//            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST.getStatusCode())
//                    .entity("Customer with id " + customerNumber + " does not exist").build());
//        }
    }
*/

}
