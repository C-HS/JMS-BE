package com.iaito.shipping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.shipping.model.Packaging;

@Repository
public interface PackagingRepository extends JpaRepository<Packaging, Long> {

}
