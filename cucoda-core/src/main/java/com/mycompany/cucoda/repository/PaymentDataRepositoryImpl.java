package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.exception.PaymentNotFoundException;
import com.mycompany.cucoda.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;


@Stateless
public class PaymentDataRepositoryImpl implements PaymentDataRepository {


    private static final Logger LOG = Logger.getLogger(PaymentDataRepositoryImpl.class.getName());

    private Map<CustomerNumber, Map<PaymentId, Payment>> payments = new HashMap<>();



    @Override
    public PaymentId createPayment(CustomerNumber customerNumber, Payment payment) {

        Map<PaymentId, Payment> customerPayments = payments.get(customerNumber);

        if (customerPayments.isEmpty()) {
            customerPayments = new HashMap<PaymentId, Payment>();
        }

        customerPayments.put(payment.getId(), payment);
        payments.put(customerNumber, customerPayments);

        return payment.getId();

    }

    @Override
    public void updatePayment(CustomerNumber customerNumber, Payment payment) {

        Map<PaymentId, Payment> customerPayments = payments.get(customerNumber);
        findPaymentDataBy(customerNumber, payment.getId());

        customerPayments.put(payment.getId(), payment);
        payments.put(customerNumber, customerPayments);
    }

    @Override
    public PaymentId deletePayment(CustomerNumber customerNumber, PaymentId paymentId) {

        Payment existingPayment = findPaymentDataBy(customerNumber, paymentId);

        Map<PaymentId, Payment> customerPayments = payments.get(customerNumber);
        customerPayments.remove(existingPayment);

        return paymentId;
    }

    @Override
    public Payment findPaymentDataBy(CustomerNumber customerNumber, PaymentId paymentId) {
        Map<PaymentId, Payment> customerPayments = payments.get(customerNumber);

        if (customerPayments.isEmpty()) {
            final String msg = String.format("Could't found any customer payment data for paymentId %s", paymentId);
            LOG.error("PaymentNotFoundException: " + msg);
        }

        Payment existingPayment = customerPayments.get(paymentId);
        if (existingPayment == null) {
            final String msg = String.format("Could't found any customer payment data for paymentId %s", paymentId);
            LOG.error("PaymentDataRepositoryImpl: " + msg);
            throw new PaymentNotFoundException(msg);
        }

        return existingPayment;
    }

    @Override
    public List<Payment> findPaymentDataBy(CustomerNumber customerNumber) {

        Map<PaymentId, Payment> customerPayments = payments.get(customerNumber);

        if (customerPayments.isEmpty()) {
            final String msg = String.format("Could't found any customer payment data for customerNumber %s", customerNumber);
            LOG.error("PaymentDataRepositoryImpl: " + msg);
        }

        return customerPayments.values().stream()
                .collect(Collectors.toList());
    }
}
