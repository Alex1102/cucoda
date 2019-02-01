package com.mycompany.cucoda.service;


import com.mycompany.cucoda.model.Customer;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.model.Passport;
import com.mycompany.cucoda.model.PassportId;

public interface PassportDataService {

	PassportId createPassportData(final Passport passport, final CustomerNumber customerNumber);

	Passport getPassportData(final CustomerNumber customerNumber);

	void updatePassportData(final Passport passport, final CustomerNumber customerNumber);

	void deletePassportData(final PassportId passportId, final CustomerNumber customerNumber);

	Passport findPassportByCustomerNumberOrThrowsException(CustomerNumber customerNumber);

	Passport findPassportByCustomerNumberAndPassportIdOrThrowsException(PassportId passportId, CustomerNumber customerNumber);

}
