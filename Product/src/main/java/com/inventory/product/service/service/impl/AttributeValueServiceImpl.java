package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.AttributeValueDTO;
import com.inventory.product.service.model.AttributeValue;
import com.inventory.product.service.repository.AttributeValueRepository;
import com.inventory.product.service.service.AttributeValueService;

@Service
public class AttributeValueServiceImpl implements AttributeValueService{
	
	Logger logger = LoggerFactory.getLogger(AttributeValueServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired AttributeValueRepository attributeValueRepository;

	@Override
	public AttributeValueDTO getAttributeValueById(long attributeValueId) {

		return modelMapper.map(attributeValueRepository.findById(attributeValueId).get(), AttributeValueDTO.class);
	}

	@Override
	public List<AttributeValueDTO> getAllAttributeValue() {

		return attributeValueRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, AttributeValueDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public AttributeValueDTO addAttributeValue(AttributeValue attributeValue) {
		
		return modelMapper.map(attributeValueRepository.save(attributeValue), AttributeValueDTO.class);
	}

	@Override
	public AttributeValueDTO updateAttributeValue(AttributeValue attributeValue) {
		
		AttributeValue attributeValueToUpdate = attributeValueRepository.findById(attributeValue.getAttributeValueId()).get();
		
		attributeValueToUpdate.setProductId(attributeValue.getProductId());
		attributeValueToUpdate.setAttributeId(attributeValue.getAttributeId());
		attributeValueToUpdate.setAttributeValue(attributeValue.getAttributeValue());
		attributeValueToUpdate.setCreateDatetime(attributeValue.getCreateDatetime());
		attributeValueToUpdate.setStatus(attributeValue.getStatus());
		return modelMapper.map(attributeValueRepository.save(attributeValueToUpdate), AttributeValueDTO.class);
		
	}

	@Override
	public void deleteAttributeValue(long attributeValueId) {
		attributeValueRepository.deleteById(attributeValueId);
		
	}

}
