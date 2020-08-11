package com.iaito.order.service.vendor;

import java.util.List;

import com.iaito.order.dto.vendor.VendorContactDTO;
import com.iaito.order.model.vendor.VendorContact;

public interface VendorContactService{

    public VendorContactDTO getVendorContactById(long vendorContactId);
    public List<VendorContactDTO> getAllVendorContacts();
    public VendorContactDTO addVendorContact(VendorContact cendorContact);
    public VendorContactDTO updateVendorContact(VendorContact vendorContact);
    public void deleteVendorContact(long vendorContactId);
}