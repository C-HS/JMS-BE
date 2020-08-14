package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.OutgoingShipmentItemDTO;
import com.iaito.shipping.model.OutgoingShipmentItem;

public interface OutgoingShipmentItemService {
	
    public OutgoingShipmentItemDTO getOutgoingShipmentItemById(long outgoingShipmentItemId);
    public List<OutgoingShipmentItemDTO> getAllOutgoingShipmentItems();
    public OutgoingShipmentItemDTO addOutgoingShipmentItem(OutgoingShipmentItem outgoingShipmentItem);
    public OutgoingShipmentItemDTO updateOutgoingShipmentItem(OutgoingShipmentItem outgoingShipmentItem);
    public void deleteOutgoingShipmentItem(long outgoingShipmentItemId);

}
