package com.mycompany.cucoda.rest;


import com.mycompany.cucoda.service.MonitoringService;
import com.mycompany.cucoda.rest.api.MonitoringRestService;
import com.mycompany.cucoda.rest.util.Authorizations;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.jboss.resteasy.plugins.server.embedded.SimpleSecurityDomain;
import org.jboss.resteasy.spi.HttpResponse;


@Path("/monitoring")
public class MonitoringRestServiceBean implements MonitoringRestService {


    private static final Logger LOG = Logger.getLogger(MonitoringRestServiceBean.class.getName());

    @Context // do not rename or delete httpRequest, used for LoggingAspect
//    private HttpServletRequest httpRequest;
//    @Context
//    private HttpResponse httpResponse;
//    @Inject
//    private MonitoringService service;


    //    @RolesAllowed(value = {Authorizations.MYGROUP})
    @Override
    @RolesAllowed(value = Authorizations.SUPER_USER)
    public String ping() {
        return "pong";
//        return service.ping();
    }

    @Override
//    @org.jboss.ejb3.annotation.SecurityDomain(value="")
//    @SecurityDomain
    @RolesAllowed(value = Authorizations.SUPER_USER)
    public String read() {
        return "read";
    }


    @Override
    @RolesAllowed(value = {Authorizations.WRITE_ROLE})
    public String write() {
        return "write";
    }

}
