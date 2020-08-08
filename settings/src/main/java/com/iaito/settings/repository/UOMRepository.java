package com.iaito.settings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.settings.model.UOM;


@Repository
public interface UOMRepository extends JpaRepository<UOM, Long>  {

}
