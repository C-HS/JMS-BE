package com.iaito.order.service.payment;

import java.util.List;

import com.iaito.order.dto.payment.PaymentTermsDTO;
import com.iaito.order.model.payment.PaymentTerms;

public interface PaymentTermsService {
	
    public PaymentTermsDTO getPaymentTermsById(long paymentTermsId);
    public List<PaymentTermsDTO> getAllPaymentTerms();
    public PaymentTermsDTO addPaymentTerms(PaymentTerms paymentTerms);
    public PaymentTermsDTO updatePaymentTerms(PaymentTerms paymentTerms);
    public void deletePaymentTerms(long paymentTermsId);

}
