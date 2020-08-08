package com.iaito.settings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.settings.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
