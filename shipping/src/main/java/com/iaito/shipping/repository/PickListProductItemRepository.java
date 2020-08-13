package com.iaito.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.shipping.model.PickListProductItem;

@Repository
public interface PickListProductItemRepository extends JpaRepository<PickListProductItem, Long>  {

}
