package com.mycompany.cucoda.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.mycompany.cucoda.model.Customer;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.model.Market;
import com.mycompany.cucoda.service.CustomerDataService;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.mock.MockHttpRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ReadCustomerDataRestBeanTest extends AbstractRestBase {



    @InjectMocks
    private ReadCustomerDataRestBean underTest;
    @Mock
    private CustomerDataService service;


    @Before
    public void init() throws Exception {
        dispatcher.getRegistry().addSingletonResource(underTest);
    }

    @Test
    public void getCustomer() throws URISyntaxException, IOException {

        final CustomerNumber customerNumber = new CustomerNumber("1234");
        final MockHttpRequest request = MockHttpRequest.get("customers/" + customerNumber.getId());
//        request.contentType(Login.MEDIA_TYPE);
//        request.content(Serializer.convert(login).getBytes());
        request.header(HttpHeaders.ACCEPT, Customer.MEDIA_TYPE);

        final Customer customer = new Customer(customerNumber, Market.MY_COMPANY.getId());
        when(service.getCustomer(customerNumber)).thenReturn(customer);


        dispatcher.invoke(request, response);


        String json = response.getContentAsString();
        System.out.println(json);



////        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
//        ObjectMapper mapper = resolver.getContext(null);
//
//        Customer part = new Customer();
//        String result = mapper.writeValueAsString(part);
//        JsonNode tree = mapper.reader().readTree(result);
//        Customer partResult = mapper.treeToValue(tree, Customer.class);
//        System.out.println(partResult.toString());





//        ObjectMapper mapper = resolver.getContext(null);
//        Customer customerResult = mapper.reader()
//                .forType(new TypeReference<Customer>() {})
//                .readValue(json);


        // Assert
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());


//        final Customer responseCustomer = null;
//        assertEquals(customer, responseCustomer);
    }

}