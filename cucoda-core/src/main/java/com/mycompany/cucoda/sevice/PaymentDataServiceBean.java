package com.mycompany.cucoda.sevice;


import com.mycompany.cucoda.model.Customer;
import com.mycompany.cucoda.model.CustomerNumber;
import com.mycompany.cucoda.model.Payment;
import com.mycompany.cucoda.model.PaymentId;
import com.mycompany.cucoda.service.PaymentDataService;

import javax.ejb.Stateless;


@Stateless
public class PaymentDataServiceBean implements PaymentDataService {

    @Override
    public PaymentId createPaymentData(Payment payment, CustomerNumber customerNumber) {
        return null;
    }

    @Override
    public Customer getPaymentData(PaymentId paymentId, CustomerNumber customerNumber) {
        return null;
    }

    @Override
    public void updatePaymentData(Payment payment, CustomerNumber customerNumber) {

    }

    @Override
    public void deletePaymentData(PaymentId paymentId, CustomerNumber customerNumber) {

    }
}
