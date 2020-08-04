package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.ProductCustomerDTO;
import com.inventory.product.service.model.ProductCustomer;

public interface ProductCustomerService {
	
    public ProductCustomerDTO getProductCustomerById(long productCustomerId);
    public List<ProductCustomerDTO> getAllProductCustomers();
    public ProductCustomerDTO addProductCustomer(ProductCustomer productCustomer);
    public ProductCustomerDTO updateProductCustomer(ProductCustomer productCustomer);
    public void deleteProductCustomer(long productCustomerId);

}
