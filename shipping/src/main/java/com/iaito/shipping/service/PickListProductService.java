package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.PickListProductDTO;
import com.iaito.shipping.model.PickListProduct;

public interface PickListProductService {

    public PickListProductDTO getPickListProductById(long pickListProductId);
    public List<PickListProductDTO> getAllPickListProducts();
    public PickListProductDTO addPickListProduct(PickListProduct pickListProduct);
    public PickListProductDTO updatePickListProduct(PickListProduct pickListProduct);
    public void deletePickListProduct(long pickListProductId);
}
