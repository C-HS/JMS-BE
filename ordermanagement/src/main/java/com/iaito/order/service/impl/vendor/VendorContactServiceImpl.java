package com.iaito.order.service.impl.vendor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.vendor.VendorContactDTO;
import com.iaito.order.model.vendor.VendorContact;
import com.iaito.order.repository.vendor.VendorContactRepository;
import com.iaito.order.service.vendor.VendorContactService;


@Service
public class VendorContactServiceImpl implements VendorContactService{
	
	Logger logger = LoggerFactory.getLogger(VendorContactServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired VendorContactRepository vendorContactRepository;

	@Override
	public VendorContactDTO getVendorContactById(long vendorContactId) {

		return modelMapper.map(vendorContactRepository.findById(vendorContactId).get(), VendorContactDTO.class);
	}

	@Override
	public List<VendorContactDTO> getAllVendorContacts() {
		return vendorContactRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, VendorContactDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public VendorContactDTO addVendorContact(VendorContact cendorContact) {
		cendorContact.setCreateDatetime(new java.util.Date());
		cendorContact.setStatus("Active");
		
		return modelMapper.map(vendorContactRepository.save(cendorContact), VendorContactDTO.class);
	}

	@Override
	public VendorContactDTO updateVendorContact(VendorContact vendorContact) {
		
		VendorContact vendorContactToUpdate = vendorContactRepository.findById(vendorContact.getVendorContactId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(vendorContactRepository.save(vendorContactToUpdate), VendorContactDTO.class);
	}

	@Override
	public void deleteVendorContact(long vendorContactId) {

		vendorContactRepository.deleteById(vendorContactId);
		
	}

}
