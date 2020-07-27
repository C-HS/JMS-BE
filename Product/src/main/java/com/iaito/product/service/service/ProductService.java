package com.iaito.product.service.service;

import java.util.List;

import com.iaito.product.service.dto.ProductDTO;
import com.iaito.product.service.model.Product;

public interface ProductService {
	public ProductDTO getProduct(long productId);
	public List<ProductDTO> getAllProducts();
	public ProductDTO addProduct(Product product);
	public ProductDTO updateProduct(Product product);
	public void deleteProduct(long productId);
}
