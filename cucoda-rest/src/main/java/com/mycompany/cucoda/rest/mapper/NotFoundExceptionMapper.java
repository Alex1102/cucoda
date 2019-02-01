package com.mycompany.cucoda.rest.mapper;


import com.mycompany.cucoda.rest.mapper.constants.RestConstants;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {

    public Response toResponse(EntityNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .header(RestConstants.X_UI_ENHANCED_STATUS, e.getMessage())
                .build();
    }
}
