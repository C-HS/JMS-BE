package com.iaito.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.inventory.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>  {

}
