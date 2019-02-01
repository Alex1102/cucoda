package com.mycompany.cucoda.rest.mapper;


import com.mycompany.cucoda.exception.PaymentAlreadyExistsException;
import com.mycompany.cucoda.rest.mapper.constants.RestConstants;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class PaymentAlreadyExistsExceptionMapper implements ExceptionMapper<PaymentAlreadyExistsException> {

	public Response toResponse(PaymentAlreadyExistsException e) {
		return Response.status(Response.Status.CONFLICT)
				.header(RestConstants.X_UI_ENHANCED_STATUS, e.getMessage())
				.build();
	}
}
