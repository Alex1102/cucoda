package com.mycompany.cucoda.service;


import com.mycompany.cucoda.model.Contact;
import com.mycompany.cucoda.model.ContactId;
import com.mycompany.cucoda.model.CustomerNumber;

public interface ContactDataService {

	ContactId createContacts(final Contact contact, final CustomerNumber customerNumber);

	Contact getContacts(final CustomerNumber customerNumber);

	void updateContacts(final Contact contact, final CustomerNumber customerNumber);

	void deleteContacts(final CustomerNumber customerNumber);
}
