package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.PackagingDTO;
import com.iaito.shipping.model.Packaging;
import com.iaito.shipping.repository.PackagingRepository;
import com.iaito.shipping.service.PackagingService;

@Service
public class PackagingServiceImpl implements PackagingService{
	
	Logger logger = LoggerFactory.getLogger(PackagingServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired PackagingRepository packagingRepository;

	@Override
	public PackagingDTO getPackagingById(long packagingId) {

		return modelMapper.map(packagingRepository.findById(packagingId).get(), PackagingDTO.class);
	}

	@Override
	public List<PackagingDTO> getAllPackagings() {

		return packagingRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, PackagingDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PackagingDTO addPackaging(Packaging packaging) {

		packaging.setCreateDatetime(new java.util.Date());
		packaging.setStatus("Draft");
		
		return modelMapper.map(packagingRepository.save(packaging), PackagingDTO.class);
	}

	@Override
	public PackagingDTO updatePackaging(Packaging packaging) {

		Packaging packagingToUpdate = packagingRepository.findById(packaging.getPackagingId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(packagingRepository.save(packagingToUpdate), PackagingDTO.class);
	}

	@Override
	public void deletePackaging(long packagingId) {

		packagingRepository.deleteById(packagingId);
		
	}

}
