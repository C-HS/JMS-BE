package com.iaito.order.service.impl.payment;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.payment.PaymentTermsDTO;
import com.iaito.order.model.payment.PaymentTerms;
import com.iaito.order.repository.payment.PaymentTermsRepository;
import com.iaito.order.service.payment.PaymentTermsService;

@Service
public class PaymentTermsServiceImpl implements PaymentTermsService {
	
	Logger logger = LoggerFactory.getLogger(PaymentTermsServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired PaymentTermsRepository paymentTermsRepository;

	@Override
	public PaymentTermsDTO getPaymentTermsById(long paymentTermsId) {

		return modelMapper.map(paymentTermsRepository.findById(paymentTermsId).get(), PaymentTermsDTO.class);
	}

	@Override
	public List<PaymentTermsDTO> getAllPaymentTerms() {

		return paymentTermsRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, PaymentTermsDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PaymentTermsDTO addPaymentTerms(PaymentTerms paymentTerms) {

		paymentTerms.setCreateDatetime(new java.util.Date());
		paymentTerms.setStatus("Active");
		
		return modelMapper.map(paymentTermsRepository.save(paymentTerms), PaymentTermsDTO.class);
	}

	@Override
	public PaymentTermsDTO updatePaymentTerms(PaymentTerms paymentTerms) {

		PaymentTerms paymentTermsToUpdate = paymentTermsRepository.findById(paymentTerms.getPaymentTermsId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(paymentTermsRepository.save(paymentTermsToUpdate), PaymentTermsDTO.class);
	}

	@Override
	public void deletePaymentTerms(long paymentTermsId) {

		paymentTermsRepository.deleteById(paymentTermsId);
		
	}

}
