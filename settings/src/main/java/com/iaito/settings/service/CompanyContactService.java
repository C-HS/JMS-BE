package com.iaito.settings.service;

import java.util.List;

import com.iaito.settings.dto.CompanyContactDTO;
import com.iaito.settings.model.CompanyContact;


public interface CompanyContactService {
	
    public CompanyContactDTO getCompanyContactById(long companyContactId);
    public List<CompanyContactDTO> getAllCompanyContacts();
    public CompanyContactDTO addCompanyContact(CompanyContact companyContact);
    public CompanyContactDTO updateCompanyContact(CompanyContact companyContact);
    public void deleteCompanyContact(long companyContactId);

}
