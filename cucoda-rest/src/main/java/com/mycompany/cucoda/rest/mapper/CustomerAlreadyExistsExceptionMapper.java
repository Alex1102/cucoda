package com.mycompany.cucoda.rest.mapper;


import com.mycompany.cucoda.exception.CustomerAlreadyExistsException;
import com.mycompany.cucoda.exception.CustomerNotFoundException;
import com.mycompany.cucoda.rest.mapper.constants.RestConstants;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class CustomerAlreadyExistsExceptionMapper implements ExceptionMapper<CustomerAlreadyExistsException> {

    public Response toResponse(CustomerAlreadyExistsException e) {
        return Response.status(Response.Status.CONFLICT)
                .header(RestConstants.X_UI_ENHANCED_STATUS, e.getMessage())
                .build();
    }
}