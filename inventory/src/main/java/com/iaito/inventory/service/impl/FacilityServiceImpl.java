package com.iaito.inventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.inventory.dto.FacilityDTO;
import com.iaito.inventory.model.Facility;
import com.iaito.inventory.repository.FacilityRepository;
import com.iaito.inventory.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService{

    Logger logger = LoggerFactory.getLogger(FacilityServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired FacilityRepository facilityRepository;

    public FacilityDTO getFacilityById(long facilityId)
    {
        return modelMapper.map(facilityRepository.findById(facilityId).get(), FacilityDTO.class);

    }
    public List<FacilityDTO> getAllFacilities()
    {
        return facilityRepository
        .findAll()
        .stream()
        .map(e->modelMapper.map(e, FacilityDTO.class))
        .collect(Collectors.toList());
    }
    public FacilityDTO addFacility(Facility facility)
    {
        facility.setCreateDatetime(new java.util.Date());
		facility.setStatus("Active");
		
		return modelMapper.map(facilityRepository.save(facility), FacilityDTO.class);

    }
    public FacilityDTO updateFacility(Facility facility)
    {
        Facility facilityToUpdate = facilityRepository.findById(facility.getFacilityId()).get();
		
		//catalogToUpdate.setCatalogName(catalog.getCatalogName());
	//	catalogToUpdate.setDescription(catalog.getDescription());
		
		return modelMapper.map(facilityRepository.save(facilityToUpdate), FacilityDTO.class);

    }
    public void deleteFacility(long facilityId)
    {
        facilityRepository.deleteById(facilityId);
    }

}