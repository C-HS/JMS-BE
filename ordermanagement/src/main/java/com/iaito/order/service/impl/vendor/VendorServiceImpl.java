package com.iaito.order.service.impl.vendor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.vendor.VendorDTO;
import com.iaito.order.model.vendor.Vendor;
import com.iaito.order.repository.vendor.VendorRepository;
import com.iaito.order.service.vendor.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	
	Logger logger = LoggerFactory.getLogger(VendorServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired VendorRepository vendorRepository;

	@Override
	public VendorDTO getVendorById(long vendorId) {

		return modelMapper.map(vendorRepository.findById(vendorId).get(), VendorDTO.class);
	}

	@Override
	public List<VendorDTO> getAllVendors() {
		return vendorRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, VendorDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public VendorDTO addVendor(Vendor vendor) {

		vendor.setCreateDatetime(new java.util.Date());
		vendor.setStatus("Active");
		
		return modelMapper.map(vendorRepository.save(vendor), VendorDTO.class);
	}

	@Override
	public VendorDTO updateVendor(Vendor vendor) {

		Vendor vendorToUpdate = vendorRepository.findById(vendor.getVendorId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(vendorRepository.save(vendorToUpdate), VendorDTO.class);
	}

	@Override
	public void deleteVendor(long vendorId) {

		vendorRepository.deleteById(vendorId);
		
	}

}
