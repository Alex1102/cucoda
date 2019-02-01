package com.mycompany.cucoda.rest.mapper;

import com.mycompany.cucoda.rest.mapper.constants.RestConstants;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(WebApplicationException e) {
		return Response.status(e.getResponse().getStatus())
				.header(RestConstants.X_UI_ENHANCED_STATUS, e.getMessage())
				.build();
	}
}
