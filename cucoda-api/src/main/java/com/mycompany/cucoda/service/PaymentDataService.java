package com.mycompany.cucoda.service;


import com.mycompany.cucoda.model.*;

public interface PaymentDataService {

	PaymentId createPaymentData(final Payment payment, final CustomerNumber customerNumber);

	Customer getPaymentData(final PaymentId paymentId, final CustomerNumber customerNumber);

	void updatePaymentData(final Payment payment, final CustomerNumber customerNumber);

	void deletePaymentData(final PaymentId paymentId, final CustomerNumber customerNumber);
}
