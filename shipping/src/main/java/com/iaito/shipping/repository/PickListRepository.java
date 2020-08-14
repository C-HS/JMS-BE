package com.iaito.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.shipping.model.PickList;

@Repository
public interface PickListRepository extends JpaRepository<PickList, Long>{

}
