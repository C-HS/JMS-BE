package com.iaito.settings.service;

import java.util.List;

import com.iaito.settings.dto.CompanyDTO;
import com.iaito.settings.model.Company;


public interface CompanyService {
	
    public CompanyDTO getCompanyById(long companyId);
    public List<CompanyDTO> getAllCompanies();
    public CompanyDTO addCompany(Company company);
    public CompanyDTO updateCompany(Company company);
    public void deleteCompany(long companyId);

}
