package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.UOMDTO;
import com.inventory.product.service.model.UOM;
import com.inventory.product.service.repository.UOMRepository;
import com.inventory.product.service.service.UOMService;

@Service
public class UOMServiceImpl implements UOMService{
	
	Logger logger = LoggerFactory.getLogger(UOMServiceImpl.class);
	
    @Autowired ModelMapper modelMapper;
	@Autowired UOMRepository uomRepository;

	@Override
	public UOMDTO getUOMById(long uomId) {
		
		return modelMapper.map(uomRepository.findById(uomId).get(), UOMDTO.class);
	}

	@Override
	public List<UOMDTO> getAllUOM() {
		
		return uomRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e,UOMDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public UOMDTO addUOM(UOM uom) {
		
		uom.setCreateDatetime(new java.util.Date());
		uom.setStatus("Active");
		
		return modelMapper.map(uomRepository.save(uom), UOMDTO.class);
	}

	@Override
	public UOMDTO updateUOM(UOM uom) {

		UOM uomToUpdate = uomRepository.findById(uom.getUomId()).get();
		
		uomToUpdate.setUomName(uom.getUomName());
		uomToUpdate.setDescription(uom.getDescription());

		return modelMapper.map(uomRepository.save(uomToUpdate), UOMDTO.class);
	}

	@Override
	public void deleteUOM(long uomId) {
		uomRepository.deleteById(uomId);
		
	}

}
