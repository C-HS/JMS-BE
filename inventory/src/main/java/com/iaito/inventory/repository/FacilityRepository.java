package com.iaito.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.inventory.model.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long>  {

}
