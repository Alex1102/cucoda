package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.model.*;

public interface PassportDataRepository {

    PassportId createPassportData(final CustomerNumber customerNumber, final Passport passport);

    void updatePassportData(final CustomerNumber customerNumber, final Passport passport);

    PassportId deletePassportData(final CustomerNumber customerNumber, final PassportId passportId);

    Passport findPassportDataBy(final CustomerNumber customerNumber);

    Passport findPassportDataBy(CustomerNumber customerNumber, PassportId passportId);

}
