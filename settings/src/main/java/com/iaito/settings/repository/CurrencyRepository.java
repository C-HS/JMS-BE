package com.iaito.settings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.settings.model.Currency;


@Repository
public interface CurrencyRepository  extends JpaRepository<Currency, Long> {

}
