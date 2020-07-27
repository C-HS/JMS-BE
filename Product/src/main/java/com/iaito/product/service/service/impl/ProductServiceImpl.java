package com.iaito.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.product.service.dto.ProductDTO;
import com.iaito.product.service.model.Product;
import com.iaito.product.service.repository.ProductRepository;
import com.iaito.product.service.service.ProductService;
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
		productToUpdate.setProductCost(product.getProductCost());
		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setProductPrice(product.getProductPrice());
		productToUpdate.setProductTax(product.getProductTax());
		return modelMapper.map(productRepository.save(productToUpdate), ProductDTO.class);
	}

	@Override
	public void deleteProduct(long productId) {
		productRepository.deleteById(productId);
	}

}
