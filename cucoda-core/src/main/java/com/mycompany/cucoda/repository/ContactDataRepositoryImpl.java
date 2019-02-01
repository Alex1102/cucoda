package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.model.Contact;
import com.mycompany.cucoda.model.ContactId;
import com.mycompany.cucoda.model.CustomerNumber;

import java.util.List;
import javax.ejb.Stateless;


@Stateless
public class ContactDataRepositoryImpl implements ContactDataRepository {


    @Override
    public ContactId createContact(CustomerNumber customerNumber, Contact contact) {
        return null;
    }

    @Override
    public void updateContact(CustomerNumber customerNumber, Contact contact) {

    }

    @Override
    public ContactId deleteContact(CustomerNumber customerNumber, ContactId contactId) {
        return null;
    }

    @Override
    public Contact findContactBy(CustomerNumber customerNumber, ContactId contactId) {
        return null;
    }

    @Override
    public List<Contact> findContactBy(CustomerNumber customerNumber) {
        return null;
    }
}
