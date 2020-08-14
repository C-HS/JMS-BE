package com.iaito.shipping.service;

import java.util.List;

import com.iaito.shipping.dto.TransportDTO;
import com.iaito.shipping.model.Transport;

public interface TransportService {
	
    public TransportDTO getTransportById(long transportId);
    public List<TransportDTO> getAllTransports();
    public TransportDTO addTransport(Transport transport);
    public TransportDTO updateTransport(Transport transport);
    public void deleteTransport(long transportId);

}
