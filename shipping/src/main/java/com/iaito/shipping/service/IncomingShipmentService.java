package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.IncomingShipmentDTO;
import com.iaito.shipping.model.IncomingShipment;

public interface IncomingShipmentService {
	
    public IncomingShipmentDTO getIncomingShipmentById(long incomingShipmentId);
    public List<IncomingShipmentDTO> getAllIncomingShipments();
    public IncomingShipmentDTO addIncomingShipment(IncomingShipment incomingShipment);
    public IncomingShipmentDTO updateIncomingShipment(IncomingShipment incomingShipment);
    public void deleteIncomingShipment(long incomingShipmentId);

}
