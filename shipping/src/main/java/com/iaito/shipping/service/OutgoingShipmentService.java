package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.OutgoingShipmentDTO;
import com.iaito.shipping.model.OutgoingShipment;

public interface OutgoingShipmentService {

    public OutgoingShipmentDTO getOutgoingShipmentById(long outgoingShipmentId);
    public List<OutgoingShipmentDTO> getAllOutgoingShipments();
    public OutgoingShipmentDTO addOutgoingShipment(OutgoingShipment outgoingShipment);
    public OutgoingShipmentDTO updateOutgoingShipment(OutgoingShipment outgoingShipment);
    public void deleteOutgoingShipment(long outgoingShipmentId);
}
