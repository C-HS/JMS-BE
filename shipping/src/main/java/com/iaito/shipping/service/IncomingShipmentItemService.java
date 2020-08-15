package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.IncomingShipmentItemDTO;
import com.iaito.shipping.model.IncomingShipmentItem;

public interface IncomingShipmentItemService {

    public IncomingShipmentItemDTO getIncomingShipmentItemById(long incomingShipmentItemId);
    public List<IncomingShipmentItemDTO> getAllIncomingShipmentItems();
    public IncomingShipmentItemDTO addIncomingShipmentItem(IncomingShipmentItem incomingShipmentItem);
    public IncomingShipmentItemDTO updateIncomingShipmentItem(IncomingShipmentItem incomingShipmentItem);
    public void deleteIncomingShipmentItem(long incomingShipmentItemId);
}
