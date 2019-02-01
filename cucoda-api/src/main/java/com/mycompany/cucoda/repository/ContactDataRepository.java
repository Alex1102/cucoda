package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.model.*;

import java.util.List;

public interface ContactDataRepository {

    ContactId createContact(final CustomerNumber customerNumber, final Contact contact);

    void updateContact(final CustomerNumber customerNumber, final Contact contact);

    ContactId deleteContact(final CustomerNumber customerNumber, final ContactId contactId);

    Contact findContactBy(final CustomerNumber customerNumber, final ContactId contactId);

    List<Contact> findContactBy(final CustomerNumber customerNumber);

}
