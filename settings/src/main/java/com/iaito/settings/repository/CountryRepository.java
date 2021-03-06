package com.iaito.settings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.settings.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
