package com.iaito.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.shipping.model.OutgoingShipmentItem;

@Repository
public interface OutgoingShipmentItemRepository   extends JpaRepository<OutgoingShipmentItem, Long>   {

}
