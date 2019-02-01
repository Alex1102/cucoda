package com.mycompany.cucoda.rest.mapper;


import com.mycompany.cucoda.exception.AddressAlreadyExistsException;
import com.mycompany.cucoda.rest.mapper.constants.RestConstants;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AddressAlreadyExistsExceptionMapper implements ExceptionMapper<AddressAlreadyExistsException> {

	public Response toResponse(AddressAlreadyExistsException e) {
		return Response.status(Response.Status.CONFLICT)
				.header(RestConstants.X_UI_ENHANCED_STATUS, e.getMessage())
				.build();
	}
}
