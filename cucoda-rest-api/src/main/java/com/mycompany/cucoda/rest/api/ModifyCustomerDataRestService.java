package com.mycompany.cucoda.rest.api;


import com.mycompany.cucoda.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public interface ModifyCustomerDataRestService {


    // ***************** Customer *******************

    @POST
    @Path("customers")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response createCustomer(@QueryParam("marketId") final String marketId);

//    @POST
//    @Path("customers")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    Response createCustomer(final Customer customer);


    @PUT
    @Path("customers")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response updateCustomer(@QueryParam("customerNumber") final String customerNumber, @QueryParam("marketId") final String marketId);


    @DELETE
    @Path("customers/{customerNumber}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response deleteCustomer(@PathParam("customerNumber") final String customerNumber);




    // ***************** Address *******************

    @POST
    @Path("customers/{customerNumber}/address")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response createAddress(@PathParam("customerNumber") final String customerNumber, final Address address);

    @PUT
    @Path("customers/{customerNumber}/address")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response updateAddress(@PathParam("customerNumber") final String customerNumber, final Address address);


    @DELETE
    @Path("customers/{customerNumber}/address")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response deleteAddress(@PathParam("customerNumber") final String customerNumber, final AddressId addressId);



    // **************** Passport ******************

    @POST
    @Path("customers/{customerNumber}/passport")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response createPassport(final String customerNumber, final Passport passport);


    @PUT
    @Path("customers/{customerNumber}/passport")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response updatePassport(@PathParam("customerNumber") final String customerNumber, final Passport passport);


    @DELETE
    @Path("customers/{customerNumber}/passport")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response deletePassport(@PathParam("customerNumber") final String customerNumber, final PassportId passportId);




    // **************** Payment ******************

    @POST
    @Path("customers/{customerNumber}/payment")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response createPayment(final String customerNumber, final Payment passport);


    @PUT
    @Path("customers/{customerNumber}/payment")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response updatePayment(@PathParam("customerNumber") final String customerNumber, final Payment payment);


    @DELETE
    @Path("customers/{customerNumber}/payment")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response deletePayment(@PathParam("customerNumber") final String customerNumber, final PaymentId paymentId);



    // **************** Contact ******************

    @POST
    @Path("customers/{customerNumber}/contact")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response createContact(final String customerNumber, final Contact contact);


    @PUT
    @Path("customers/{customerNumber}/contact")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response updateContact(@PathParam("customerNumber") final String customerNumber, final Contact contact);



//    When a resource is removed with DELETE, the HTTP specification requires that you
//    send a response code of 200, “OK,” and a response message body or a response code of
//204, “No Content,” without any response body. In our application, we will send a status
//    of 204 and no response message.


    @DELETE
    @Path("customers/{customerNumber}/contact")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    Response deleteContact(@PathParam("customerNumber") final String customerNumber, final ContactId contactId);
}
