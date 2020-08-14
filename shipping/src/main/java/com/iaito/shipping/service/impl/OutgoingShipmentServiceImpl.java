package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.OutgoingShipmentDTO;
import com.iaito.shipping.model.OutgoingShipment;
import com.iaito.shipping.repository.OutgoingShipmentRepository;
import com.iaito.shipping.service.OutgoingShipmentService;

@Service
public class OutgoingShipmentServiceImpl implements OutgoingShipmentService {
	
	Logger logger = LoggerFactory.getLogger(OutgoingShipmentServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired OutgoingShipmentRepository outgoingShipmentRepository;


	@Override
	public OutgoingShipmentDTO getOutgoingShipmentById(long outgoingShipmentId) {
		
		return modelMapper.map(outgoingShipmentRepository.findById(outgoingShipmentId).get(), OutgoingShipmentDTO.class);
	}

	@Override
	public List<OutgoingShipmentDTO> getAllOutgoingShipments() {

		return outgoingShipmentRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, OutgoingShipmentDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public OutgoingShipmentDTO addOutgoingShipment(OutgoingShipment outgoingShipment) {

		outgoingShipment.setCreateDatetime(new java.util.Date());
		outgoingShipment.setShipmentStatus("Draft");
		
		return modelMapper.map(outgoingShipmentRepository.save(outgoingShipment), OutgoingShipmentDTO.class);
	}

	@Override
	public OutgoingShipmentDTO updateOutgoingShipment(OutgoingShipment outgoingShipment) {

		OutgoingShipment outgoingShipmentToUpdate = outgoingShipmentRepository.findById(outgoingShipment.getOutgoingShipmentId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(outgoingShipmentRepository.save(outgoingShipmentToUpdate), OutgoingShipmentDTO.class);
	}

	@Override
	public void deleteOutgoingShipment(long outgoingShipmentId) {

		outgoingShipmentRepository.deleteById(outgoingShipmentId);
		
	}

}
