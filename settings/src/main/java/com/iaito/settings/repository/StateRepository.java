package com.iaito.settings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.settings.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
