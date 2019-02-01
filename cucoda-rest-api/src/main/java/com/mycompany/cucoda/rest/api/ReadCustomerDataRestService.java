package com.mycompany.cucoda.rest.api;




import com.mycompany.cucoda.rest.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public interface ReadCustomerDataRestService {

    @GET
    @Path("customers/{customerNumber}")
    @Produces({ Customer.MEDIA_TYPE })
    Response getCustomer(@PathParam("customerNumber") final String customerNumber);

    @GET
    @Path("customers/{customerNumber}/address")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response getAddress(@PathParam("customerNumber") final String customerNumber);

    @GET
    @Path("customers/{customerNumber}/payment")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response getPayment(@PathParam("customerNumber") final String customerNumber);

    @GET
    @Path("customers/{customerNumber}/passport")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response getPassport(@PathParam("customerNumber") final String customerNumber);

    @GET
    @Path("customers/{customerNumber}/contact")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response getContact(@PathParam("customerNumber") final String customerNumber);
}
