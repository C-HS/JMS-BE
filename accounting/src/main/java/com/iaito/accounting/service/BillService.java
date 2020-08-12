package com.iaito.accounting.service;

import java.util.List;

import com.iaito.accounting.dto.BillDTO;
import com.iaito.accounting.model.Bill;

public interface BillService {
	
    public BillDTO getBillById(long billId);
    public List<BillDTO> getAllBills();
    public BillDTO addBill(Bill bill);
    public BillDTO updateBill(Bill bill);
    public void deleteBill(long billId);

}
