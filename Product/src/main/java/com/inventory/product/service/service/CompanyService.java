package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.CompanyDTO;
import com.inventory.product.service.model.Company;

public interface CompanyService {
	
    public CompanyDTO getCompanyById(long companyId);
    public List<CompanyDTO> getAllCompanies();
    public CompanyDTO addCompany(Company company);
    public CompanyDTO updateCompany(Company company);
    public void deleteCompany(long companyId);

}
