package com.iaito.settings.service;

import java.util.List;

import com.iaito.settings.dto.CountryDTO;
import com.iaito.settings.model.Country;



public interface CountryService {
	
    public CountryDTO getCountryById(long countryId);
    public List<CountryDTO> getAllCountries();
    public CountryDTO addCountry(Country country);
    public CountryDTO updateCountry(Country country);
    public void deleteCountry(long countryId);

}
