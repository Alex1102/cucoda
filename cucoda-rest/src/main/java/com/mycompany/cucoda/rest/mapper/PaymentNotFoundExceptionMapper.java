package com.mycompany.cucoda.rest.mapper;


import com.mycompany.cucoda.exception.PaymentNotFoundException;
import com.mycompany.cucoda.rest.mapper.constants.RestConstants;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class PaymentNotFoundExceptionMapper implements ExceptionMapper<PaymentNotFoundException> {

    public Response toResponse(PaymentNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .header(RestConstants.X_UI_ENHANCED_STATUS, e.getMessage())
                .build();
    }
}