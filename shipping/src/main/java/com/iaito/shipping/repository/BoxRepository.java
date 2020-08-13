package com.iaito.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.shipping.model.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long>  {

}
