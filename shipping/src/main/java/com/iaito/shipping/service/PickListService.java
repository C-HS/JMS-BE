package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.PickListDTO;
import com.iaito.shipping.model.PickList;

public interface PickListService {

    public PickListDTO getPickListById(long pickListId);
    public List<PickListDTO> getAllPickLists();
    public PickListDTO addPickList(PickList pickList);
    public PickListDTO updatePickList(PickList pickList);
    public void deletePickList(long pickListId);
}
