package com.mycompany.cucoda.rest.mapper;


import com.mycompany.cucoda.exception.InvalidArgumentException;
import com.mycompany.cucoda.rest.mapper.constants.RestConstants;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidArgumentExceptionMapper  implements ExceptionMapper<InvalidArgumentException> {

    public Response toResponse(InvalidArgumentException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .header(RestConstants.X_UI_ENHANCED_STATUS, e.getMessage())
                .build();
    }
}