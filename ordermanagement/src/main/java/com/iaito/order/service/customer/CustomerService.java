package com.iaito.order.service.customer;

import java.util.List;

import com.iaito.order.dto.customer.CustomerDTO;
import com.iaito.order.model.customer.Customer;


public interface CustomerService{

    public CustomerDTO getCustomerById(long customerId);
    public List<CustomerDTO> getAllCustomers();
    public CustomerDTO addCustomer(Customer customer);
    public CustomerDTO updateCustomer(Customer customer);
    public void deleteCustomer(long customerId);
    
}