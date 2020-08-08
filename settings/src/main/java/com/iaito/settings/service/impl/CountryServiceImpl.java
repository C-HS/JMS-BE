package com.iaito.settings.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.settings.dto.CountryDTO;
import com.iaito.settings.model.Country;
import com.iaito.settings.repository.CountryRepository;
import com.iaito.settings.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired CountryRepository countryRepository;

	@Override
	public CountryDTO getCountryById(long countryId) {
		
		return modelMapper.map(countryRepository.findById(countryId).get(), CountryDTO.class);
	}

	@Override
	public List<CountryDTO> getAllCountries() {

		return countryRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, CountryDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CountryDTO addCountry(Country country) {

		return modelMapper.map(countryRepository.save(country), CountryDTO.class);
	}

	@Override
	public CountryDTO updateCountry(Country country) {
		
		Country countryToUpdate = countryRepository.findById(country.getCountryId()).get();
		
		countryToUpdate.setCountryName(country.getCountryName());
		
		return modelMapper.map(countryRepository.save(countryToUpdate), CountryDTO.class);
	}

	@Override
	public void deleteCountry(long countryId) {

		countryRepository.deleteById(countryId);
		
	}

}
