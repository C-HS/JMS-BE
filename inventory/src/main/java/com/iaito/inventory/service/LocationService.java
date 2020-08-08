package com.iaito.inventory.service;

import java.util.List;

import com.iaito.inventory.dto.LocationDTO;
import com.iaito.inventory.model.Location;

public interface LocationService {

    public LocationDTO getLocationById(long locationId);
    public List<LocationDTO> getAllLocations();
    public LocationDTO addLocation(Location location);
    public LocationDTO updateLocation(Location location);
    public void deleteLocation(long locationId);
}
