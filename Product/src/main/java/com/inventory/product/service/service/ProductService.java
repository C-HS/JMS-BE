package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.ProductDTO;
import com.inventory.product.service.model.Product;

public interface ProductService {
	public ProductDTO getProduct(long productId);
	public List<ProductDTO> getAllProducts();
	public ProductDTO addProduct(Product product);
	public ProductDTO updateProduct(Product product);
	public void deleteProduct(long productId);
}
