package com.mycompany.cucoda.rest;


import com.mycompany.cucoda.rest.mapper.AddressAlreadyExistsExceptionMapper;
import com.mycompany.cucoda.rest.mapper.CustomerAlreadyExistsExceptionMapper;
import com.mycompany.cucoda.rest.mapper.CustomerNotFoundExceptionMapper;

import java.util.HashMap;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Spy;


public class AbstractRestBase {


    protected Dispatcher dispatcher;
    protected MockHttpResponse response;

//    @Mock
//    SecurityContext securityContextMock;

    @Mock
    private UriInfo uriInfoMock;

    @Spy
    private final Logger logger = Logger.getLogger(ReadCustomerDataRestBean.class.getName());


    @Before
    public void setUp() throws Exception {
        dispatcher = MockDispatcherFactory.createDispatcher();

        dispatcher.getProviderFactory().registerProvider(CustomerAlreadyExistsExceptionMapper.class);
        dispatcher.getProviderFactory().registerProvider(AddressAlreadyExistsExceptionMapper.class);
        dispatcher.getProviderFactory().registerProvider(CustomerNotFoundExceptionMapper.class);
//        dispatcher.getDefaultContextObjects().put(SecurityContext.class, securityContextMock);

        response = new MockHttpResponse();

//        when(securityContextMock.getUserPrincipal()).thenReturn(new BasicUserPrincipal("test"));
    }

}
