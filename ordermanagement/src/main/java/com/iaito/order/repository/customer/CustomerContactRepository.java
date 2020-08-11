package com.iaito.order.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.order.model.customer.CustomerContact;



@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long>   {

}