package com.iaito.inventory.service;

import java.util.List;

import com.iaito.inventory.dto.FacilityDTO;
import com.iaito.inventory.model.Facility;

public interface FacilityService{

    public FacilityDTO getFacilityById(long facilityId);
    public List<FacilityDTO> getAllFacilities();
    public FacilityDTO addFacility(Facility facility);
    public FacilityDTO updateFacility(Facility facility);
    public void deleteFacility(long facilityId);

}
