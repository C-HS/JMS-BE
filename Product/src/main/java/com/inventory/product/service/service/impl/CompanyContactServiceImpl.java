package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.CompanyContactDTO;
import com.inventory.product.service.model.CompanyContact;
import com.inventory.product.service.repository.CompanyContactRepository;
import com.inventory.product.service.service.CompanyContactService;

@Service
public class CompanyContactServiceImpl implements CompanyContactService{
	
	Logger logger = LoggerFactory.getLogger(CompanyContactServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired CompanyContactRepository companyContactRepository;

	@Override
	public CompanyContactDTO getCompanyContactById(long companyContactId) {

		return modelMapper.map(companyContactRepository.findById(companyContactId).get(), CompanyContactDTO.class);
	}

	@Override
	public List<CompanyContactDTO> getAllCompanyContacts() {

		return companyContactRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, CompanyContactDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CompanyContactDTO addCompanyContact(CompanyContact companyContact) {

		return modelMapper.map(companyContactRepository.save(companyContact), CompanyContactDTO.class);
	}

	@Override
	public CompanyContactDTO updateCompanyContact(CompanyContact companyContact) {

		CompanyContact companyContactToUpdate = companyContactRepository.findById(companyContact.getCompanyContactId()).get();
		
		companyContactToUpdate.setCompany(companyContact.getCompany());
		companyContactToUpdate.setContactType(companyContact.getContactType());
		companyContactToUpdate.setContactName(companyContact.getContactName());
		companyContactToUpdate.setAddressLine1(companyContact.getAddressLine1());
		companyContactToUpdate.setAddressLine2(companyContact.getAddressLine2());
		companyContactToUpdate.setCountryId(companyContact.getCountryId());
		companyContactToUpdate.setStateId(companyContact.getStateId());
		companyContactToUpdate.setCity(companyContact.getCity());
		companyContactToUpdate.setPinCode(companyContact.getPinCode());
		companyContactToUpdate.setPhoneNo(companyContact.getPhoneNo());
		companyContactToUpdate.setMobileNo(companyContact.getMobileNo());
		companyContactToUpdate.setEmail(companyContact.getEmail());
		companyContactToUpdate.setWebsite(companyContact.getWebsite());
		companyContactToUpdate.setNotes(companyContact.getNotes());
		
		companyContactToUpdate.setCreateDatetime(companyContact.getCreateDatetime());
		companyContactToUpdate.setStatus(companyContact.getStatus());
		return modelMapper.map(companyContactRepository.save(companyContactToUpdate), CompanyContactDTO.class);
	}

	@Override
	public void deleteCompanyContact(long companyContactId) {
		companyContactRepository.deleteById(companyContactId);
		
	}

}
