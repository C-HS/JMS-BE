package com.iaito.order.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.order.model.customer.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>   {


    
}