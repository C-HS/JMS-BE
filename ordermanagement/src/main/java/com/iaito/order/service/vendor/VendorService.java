package com.iaito.order.service.vendor;

import java.util.List;

import com.iaito.order.dto.vendor.VendorDTO;
import com.iaito.order.model.vendor.Vendor;

public interface VendorService{

    public VendorDTO getVendorById(long vendorId);
    public List<VendorDTO> getAllVendors();
    public VendorDTO addVendor(Vendor vendor);
    public VendorDTO updateVendor(Vendor vendor);
    public void deleteVendor(long vendorId);
    
}