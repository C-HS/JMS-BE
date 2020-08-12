package com.iaito.order.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.order.model.payment.PaymentTerms;

@Repository
public interface PaymentTermsRepository extends JpaRepository<PaymentTerms, Long>    {

}
