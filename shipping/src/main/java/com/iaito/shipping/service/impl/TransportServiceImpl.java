package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.TransportDTO;
import com.iaito.shipping.model.Transport;
import com.iaito.shipping.repository.TransportRepository;
import com.iaito.shipping.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService{
	
	Logger logger = LoggerFactory.getLogger(TransportServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired TransportRepository transportRepository;

	@Override
	public TransportDTO getTransportById(long transportId) {

		return modelMapper.map(transportRepository.findById(transportId).get(), TransportDTO.class);
	}

	@Override
	public List<TransportDTO> getAllTransports() {

		return transportRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, TransportDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public TransportDTO addTransport(Transport transport) {

		transport.setCreateDatetime(new java.util.Date());
		transport.setStatus("Draft");
		
		return modelMapper.map(transportRepository.save(transport), TransportDTO.class);
	}

	@Override
	public TransportDTO updateTransport(Transport transport) {

		Transport transportToUpdate = transportRepository.findById(transport.getTransportId()).get();
		
		return modelMapper.map(transportRepository.save(transportToUpdate), TransportDTO.class);
	}

	@Override
	public void deleteTransport(long transportId) {

		transportRepository.deleteById(transportId);
		
	}

}
