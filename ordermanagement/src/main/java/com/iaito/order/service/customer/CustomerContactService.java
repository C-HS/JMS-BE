package com.iaito.order.service.customer;

import java.util.List;

import com.iaito.order.dto.customer.CustomerContactDTO;
import com.iaito.order.model.customer.CustomerContact;



public interface CustomerContactService{

    public CustomerContactDTO getCustomerContactById(long customerContactId);
    public List<CustomerContactDTO> getAllCustomerContacts();
    public CustomerContactDTO addCustomerContact(CustomerContact customerContact);
    public CustomerContactDTO updateCustomerContact(CustomerContact customerContact);
    public void deleteCustomerContact(long customerContactId);
}