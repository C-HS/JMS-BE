package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.service.CatalogService;
import com.inventory.product.service.dto.CatalogDTO;
import com.inventory.product.service.model.Catalog;
import com.inventory.product.service.repository.CatalogRepository;

@Service
public class CatalogServiceImpl implements CatalogService{
	
	Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired CatalogRepository catalogRepository;
	
	@Override
	public CatalogDTO getCatalogById(long catalogId) {
		
		return modelMapper.map(catalogRepository.findById(catalogId).get(), CatalogDTO.class);
	}
	
	@Override
    public List<CatalogDTO> getAllCatalog(){
		
		return catalogRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, CatalogDTO.class))
				.collect(Collectors.toList());
    }
	
	@Override
    public CatalogDTO addCatalog(Catalog catalog){
		
		catalog.setCreateDatetime(new java.util.Date());
		catalog.setStatus("Active");
		
		return modelMapper.map(catalogRepository.save(catalog), CatalogDTO.class);
		
    }
	
	@Override
    public CatalogDTO updateCatalog(Catalog catalog){
		
		
		Catalog catalogToUpdate = catalogRepository.findById(catalog.getCatalogId()).get();
		
		catalogToUpdate.setCatalogName(catalog.getCatalogName());
		catalogToUpdate.setCatalogDesc(catalog.getCatalogDesc());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(catalogRepository.save(catalogToUpdate), CatalogDTO.class);
    }
	
	@Override
    public void deleteCatalog(long catalogId){
		
		catalogRepository.deleteById(catalogId);

    }
//
//	@Override
//	public CatalogDTO catalogByName(String catalogName) {
//		return modelMapper.map(catalogRepository.findCatalogByName(catalogName), CatalogDTO.class);
//	}

	
}