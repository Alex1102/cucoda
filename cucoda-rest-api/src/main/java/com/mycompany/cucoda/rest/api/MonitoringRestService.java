package com.mycompany.cucoda.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/monitoring")
public interface MonitoringRestService {

    @GET
    @Path("/ping")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String ping();

    @GET
    @Path("/read")
    @Produces({MediaType.TEXT_PLAIN})
    String read();

    @GET
    @Path("/write")
    @Produces({MediaType.TEXT_PLAIN})
    String write();

}
