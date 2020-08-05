package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.CompanyContactDTO;
import com.inventory.product.service.model.CompanyContact;

public interface CompanyContactService {
	
    public CompanyContactDTO getCompanyContactById(long companyContactId);
    public List<CompanyContactDTO> getAllCompanyContacts();
    public CompanyContactDTO addCompanyContact(CompanyContact companyContact);
    public CompanyContactDTO updateCompanyContact(CompanyContact companyContact);
    public void deleteCompanyContact(long companyContactId);

}
