package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.CurrencyDTO;
import com.inventory.product.service.model.Currency;

public interface CurrencyService {
	
    public CurrencyDTO getCurrencyById(long currencyId);
    public List<CurrencyDTO> getAllCurrencies();
    public CurrencyDTO addCurrency(Currency currency);
    public CurrencyDTO updateCurrency(Currency currency);
    public void deleteCurrency(long currencyId);

}
