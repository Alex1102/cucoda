package com.mycompany.cucoda.repository;


import com.mycompany.cucoda.model.*;

import java.util.List;

public interface PaymentDataRepository {

    PaymentId createPayment(final CustomerNumber customerNumber, final Payment payment);

    void updatePayment(final CustomerNumber customerNumber, final Payment payment);

    PaymentId deletePayment(final CustomerNumber customerNumber, final PaymentId paymentId);

    Payment findPaymentDataBy(final CustomerNumber customerNumber, final PaymentId paymentId);

    List<Payment> findPaymentDataBy(final CustomerNumber customerNumber);
}
