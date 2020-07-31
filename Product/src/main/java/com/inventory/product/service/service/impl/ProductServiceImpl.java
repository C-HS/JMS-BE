package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.ProductDTO;
import com.inventory.product.service.model.Product;
import com.inventory.product.service.repository.ProductRepository;
import com.inventory.product.service.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired ModelMapper modelMapper;
	@Autowired ProductRepository productRepository;

	@Override
	public ProductDTO getProduct(long productId) {
		return modelMapper.map(productRepository.findById(productId).get(), ProductDTO.class);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, ProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDTO addProduct(Product product) {
		return modelMapper.map(productRepository.save(product), ProductDTO.class);
	}

	@Override
	public ProductDTO updateProduct(Product product) {
		Product productToUpdate = productRepository.findById(product.getProductId()).get();
		productToUpdate.setParentProductId(product.getParentProductId());
		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setProductType(product.getProductType());
		productToUpdate.setProductImage(product.getProductImage());
		productToUpdate.setCanBeSold(product.getCanBeSold());
		productToUpdate.setCanBePurchased(product.getCanBePurchased());
		productToUpdate.setCanBeManufactured(product.getCanBeManufactured());
		productToUpdate.setTraceability(product.getTraceability());
		productToUpdate.setInternalReference(product.getInternalReference());
		productToUpdate.setCategoryId(product.getCategoryId());
		productToUpdate.setHsnCode(product.getHsnCode());
		productToUpdate.setHsnDescription(product.getHsnDescription());
		productToUpdate.setSalesPrice(product.getSalesPrice());
		productToUpdate.setSalesCurrency(product.getSalesCurrency());
		productToUpdate.setCostPrice(product.getCostPrice());
		productToUpdate.setCostCurrency(product.getCostCurrency());
		productToUpdate.setUom(product.getUom());
		productToUpdate.setCompanyId(product.getCompanyId());
		productToUpdate.setWeight(product.getWeight());
		
		productToUpdate.setDescription(product.getDescription());
		productToUpdate.setCreateDatetime(product.getCreateDatetime());
		productToUpdate.setStatus(product.getStatus());
		
		
		return modelMapper.map(productRepository.save(productToUpdate), ProductDTO.class);
	}

	@Override
	public void deleteProduct(long productId) {
		productRepository.deleteById(productId);
	}

}
