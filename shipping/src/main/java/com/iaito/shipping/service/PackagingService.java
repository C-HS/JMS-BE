package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.PackagingDTO;
import com.iaito.shipping.model.Packaging;

public interface PackagingService {
	
    public PackagingDTO getPackagingById(long packagingId);
    public List<PackagingDTO> getAllPackagings();
    public PackagingDTO addPackaging(Packaging packaging);
    public PackagingDTO updatePackaging(Packaging packaging);
    public void deletePackaging(long packagingId);

}
