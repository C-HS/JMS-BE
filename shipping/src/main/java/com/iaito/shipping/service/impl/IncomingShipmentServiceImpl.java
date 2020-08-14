package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.IncomingShipmentDTO;
import com.iaito.shipping.model.IncomingShipment;
import com.iaito.shipping.repository.IncomingShipmentRepository;
import com.iaito.shipping.service.IncomingShipmentService;


@Service
public class IncomingShipmentServiceImpl implements IncomingShipmentService{

	
	Logger logger = LoggerFactory.getLogger(IncomingShipmentServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired IncomingShipmentRepository incomingShipmentRepository;
	
	@Override
	public IncomingShipmentDTO getIncomingShipmentById(long incomingShipmentId) {

		return modelMapper.map(incomingShipmentRepository.findById(incomingShipmentId).get(), IncomingShipmentDTO.class);
	}

	@Override
	public List<IncomingShipmentDTO> getAllIncomingShipments() {

		return incomingShipmentRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, IncomingShipmentDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public IncomingShipmentDTO addIncomingShipment(IncomingShipment incomingShipment) {

		incomingShipment.setCreateDatetime(new java.util.Date());
		incomingShipment.setShipmentStatus("Draft");
		
		return modelMapper.map(incomingShipmentRepository.save(incomingShipment), IncomingShipmentDTO.class);
	}

	@Override
	public IncomingShipmentDTO updateIncomingShipment(IncomingShipment incomingShipment) {

		IncomingShipment incomingShipmentToUpdate = incomingShipmentRepository.findById(incomingShipment.getIncomingShipmentId()).get();

		
		return modelMapper.map(incomingShipmentRepository.save(incomingShipmentToUpdate), IncomingShipmentDTO.class);
	}

	@Override
	public void deleteIncomingShipment(long incomingShipmentId) {

		incomingShipmentRepository.deleteById(incomingShipmentId);
		
	}

}
