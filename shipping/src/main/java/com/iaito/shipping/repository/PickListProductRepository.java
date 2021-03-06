package com.iaito.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.shipping.model.PickListProduct;

@Repository
public interface PickListProductRepository extends JpaRepository<PickListProduct, Long> {

}
