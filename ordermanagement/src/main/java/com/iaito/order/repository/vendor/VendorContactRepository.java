package com.iaito.order.repository.vendor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.order.model.vendor.VendorContact;

@Repository
public interface VendorContactRepository extends JpaRepository<VendorContact, Long>   {

}
