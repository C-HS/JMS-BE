package com.iaito.inventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.inventory.dto.LocationDTO;
import com.iaito.inventory.model.Location;
import com.iaito.inventory.repository.LocationRepository;
import com.iaito.inventory.service.LocationService;


@Service
public class LocationServiceImpl implements LocationService{
	
    Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired LocationRepository locationRepository;

	@Override
	public LocationDTO getLocationById(long locationId) {

		return modelMapper.map(locationRepository.findById(locationId).get(), LocationDTO.class);
	}

	@Override
	public List<LocationDTO> getAllLocations() {

        return locationRepository
        .findAll()
        .stream()
        .map(e->modelMapper.map(e, LocationDTO.class))
        .collect(Collectors.toList());
	}

	@Override
	public LocationDTO addLocation(Location location) {

		location.setCreateDatetime(new java.util.Date());
		location.setStatus("Active");
		
		return modelMapper.map(locationRepository.save(location), LocationDTO.class);
	}

	@Override
	public LocationDTO updateLocation(Location location) {

		Location locationToUpdate = locationRepository.findById(location.getLocationId()).get();
		
		//catalogToUpdate.setCatalogName(catalog.getCatalogName());
	//	catalogToUpdate.setDescription(catalog.getDescription());
		
		return modelMapper.map(locationRepository.save(locationToUpdate), LocationDTO.class);
	}

	@Override
	public void deleteLocation(long locationId) {
		locationRepository.deleteById(locationId);
		
	}

}
