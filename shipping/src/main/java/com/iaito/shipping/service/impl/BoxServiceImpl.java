package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.BoxDTO;
import com.iaito.shipping.model.Box;
import com.iaito.shipping.repository.BoxRepository;
import com.iaito.shipping.service.BoxService;

@Service
public class BoxServiceImpl implements BoxService{
	
	Logger logger = LoggerFactory.getLogger(BoxServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired BoxRepository boxRepository;

	@Override
	public BoxDTO getBoxById(long boxId) {

		return modelMapper.map(boxRepository.findById(boxId).get(), BoxDTO.class);
	}

	@Override
	public List<BoxDTO> getAllBoxes() {

		return boxRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, BoxDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public BoxDTO addBox(Box box) {

		box.setCreateDatetime(new java.util.Date());
		box.setStatus("Draft");
		
		return modelMapper.map(boxRepository.save(box), BoxDTO.class);
	}

	@Override
	public BoxDTO updateBox(Box box) {

		Box boxToUpdate = boxRepository.findById(box.getBoxId()).get();

		
		return modelMapper.map(boxRepository.save(boxToUpdate), BoxDTO.class);
	}

	@Override
	public void deleteBox(long boxId) {

		boxRepository.deleteById(boxId);
		
	}

}
