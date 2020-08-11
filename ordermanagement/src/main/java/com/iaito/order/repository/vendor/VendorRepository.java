package com.iaito.order.repository.vendor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.order.model.vendor.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>   {


    
}
