package com.iaito.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.shipping.model.OutgoingShipment;

@Repository
public interface OutgoingShipmentRepository  extends JpaRepository<OutgoingShipment, Long>   {

}
