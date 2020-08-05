package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.CompanyDTO;
import com.inventory.product.service.model.Company;
import com.inventory.product.service.repository.CompanyRepository;
import com.inventory.product.service.service.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService{
	
	Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired CompanyRepository companyRepository;

	@Override
	public CompanyDTO getCompanyById(long companyId) {

		return modelMapper.map(companyRepository.findById(companyId).get(), CompanyDTO.class);
	}

	@Override
	public List<CompanyDTO> getAllCompanies() {

		return companyRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, CompanyDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CompanyDTO addCompany(Company company) {

		return modelMapper.map(companyRepository.save(company), CompanyDTO.class);
	}

	@Override
	public CompanyDTO updateCompany(Company company) {
		
		Company companyToUpdate = companyRepository.findById(company.getCompanyId()).get();
		
		companyToUpdate.setCompanyName(company.getCompanyName());
		companyToUpdate.setAddressLine1(company.getAddressLine1());
		companyToUpdate.setAddressLine2(company.getAddressLine2());
		companyToUpdate.setCountryId(company.getCountryId());
		companyToUpdate.setStateId(company.getStateId());
		companyToUpdate.setCity(company.getCity());
		companyToUpdate.setPinCode(company.getPinCode());
		companyToUpdate.setPhoneNo(company.getPhoneNo());
		companyToUpdate.setMobileNo(company.getMobileNo());
		companyToUpdate.setEmail(company.getEmail());
		companyToUpdate.setWebsite(company.getWebsite());
		companyToUpdate.setGstinNo(company.getGstinNo());
		companyToUpdate.setRegistrationNo(company.getRegistrationNo());
		companyToUpdate.setCurrencyId(company.getCurrencyId());
		companyToUpdate.setCompanyLogo(company.getCompanyLogo());
		
		companyToUpdate.setCreateDatetime(company.getCreateDatetime());
		companyToUpdate.setStatus(company.getStatus());
		return modelMapper.map(companyRepository.save(companyToUpdate), CompanyDTO.class);
	}

	@Override
	public void deleteCompany(long companyId) {
		companyRepository.deleteById(companyId);
		
	}

}
