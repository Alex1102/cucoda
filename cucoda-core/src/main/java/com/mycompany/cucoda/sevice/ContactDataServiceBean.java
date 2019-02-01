package com.mycompany.cucoda.sevice;

import com.mycompany.cucoda.model.Contact;
import com.mycompany.cucoda.model.ContactId;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.repository.ContactDataRepository;
import com.mycompany.cucoda.service.ContactDataService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class ContactDataServiceBean implements ContactDataService {


    private static final Logger LOG = Logger.getLogger(ContactDataServiceBean.class.getName());

    @EJB
    private ContactDataRepository repository;


    @Override
    public ContactId createContacts(Contact contact, CustomerNumber customerNumber) {
        return null;
    }

    @Override
    public Contact getContacts(CustomerNumber customerNumber) {
        return null;
    }

    @Override
    public void updateContacts(Contact contact, CustomerNumber customerNumber) {

    }

    @Override
    public void deleteContacts(CustomerNumber customerNumber) {

    }
}
