package com.iaito.settings.service;

import java.util.List;

import com.iaito.settings.dto.CurrencyDTO;
import com.iaito.settings.model.Currency;


public interface CurrencyService {
	
    public CurrencyDTO getCurrencyById(long currencyId);
    public List<CurrencyDTO> getAllCurrencies();
    public CurrencyDTO addCurrency(Currency currency);
    public CurrencyDTO updateCurrency(Currency currency);
    public void deleteCurrency(long currencyId);

}
