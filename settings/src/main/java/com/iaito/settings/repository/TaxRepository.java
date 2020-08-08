package com.iaito.settings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.settings.model.Tax;


@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {

}
