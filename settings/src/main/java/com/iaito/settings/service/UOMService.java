package com.iaito.settings.service;

import java.util.List;

import com.iaito.settings.dto.UOMDTO;
import com.iaito.settings.model.UOM;


public interface UOMService {
	
    public UOMDTO getUOMById(long uomId);
    public List<UOMDTO> getAllUOM();
    public UOMDTO addUOM(UOM uom);
    public UOMDTO updateUOM(UOM uom);
    public void deleteUOM(long uomId);

}
