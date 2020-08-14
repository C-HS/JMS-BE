package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.PickListProductItemDTO;
import com.iaito.shipping.model.PickListProductItem;

public interface PickListProductItemService {

    public PickListProductItemDTO getPickListProductItemById(long pickListProductItemId);
    public List<PickListProductItemDTO> getAllPickListProductItems();
    public PickListProductItemDTO addPickListProductItem(PickListProductItem pickListProductItem);
    public PickListProductItemDTO updatePickListProductItem(PickListProductItem pickListProductItem);
    public void deletePickListProductItem(long pickListProductItemId);
}
