package com.iaito.settings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.settings.model.CompanyContact;


@Repository
public interface CompanyContactRepository extends JpaRepository<CompanyContact, Long>  {

}
