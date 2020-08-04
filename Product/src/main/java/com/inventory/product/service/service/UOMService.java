package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.UOMDTO;
import com.inventory.product.service.model.UOM;

public interface UOMService {
	
    public UOMDTO getUOMById(long uomId);
    public List<UOMDTO> getAllUOM();
    public UOMDTO addUOM(UOM uom);
    public UOMDTO updateUOM(UOM uom);
    public void deleteUOM(long uomId);

}
