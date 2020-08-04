package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventory.product.service.dto.CurrencyDTO;
import com.inventory.product.service.model.Currency;
import com.inventory.product.service.repository.CurrencyRepository;
import com.inventory.product.service.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService{
	
	Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);
	@Autowired ModelMapper modelMapper;
	@Autowired CurrencyRepository currencyRepository;

	@Override
	public CurrencyDTO getCurrencyById(long currencyId) {
		
		return modelMapper.map(currencyRepository.findById(currencyId).get(), CurrencyDTO.class);
	}

	@Override
	public List<CurrencyDTO> getAllCurrencies() {

		return currencyRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e,CurrencyDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CurrencyDTO addCurrency(Currency currency) {

		currency.setCreateDatetime(new java.util.Date());
		currency.setStatus("Active");
		
		return modelMapper.map(currencyRepository.save(currency), CurrencyDTO.class);
	}

	@Override
	public CurrencyDTO updateCurrency(Currency currency) {

		Currency currencyToUpdate = currencyRepository.findById(currency.getCurrencyId()).get();
		
		currencyToUpdate.setCurrencyName(currency.getCurrencyName());
		currencyToUpdate.setCurrencyCode(currency.getCurrencyCode());
		currencyToUpdate.setCurrencyLogo(currency.getCurrencyLogo());

		return modelMapper.map(currencyRepository.save(currencyToUpdate), CurrencyDTO.class);
	}

	@Override
	public void deleteCurrency(long currencyId) {
		currencyRepository.deleteById(currencyId);
		
	}

}
