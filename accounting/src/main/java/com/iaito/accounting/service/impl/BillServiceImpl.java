package com.iaito.accounting.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.accounting.dto.BillDTO;
import com.iaito.accounting.model.Bill;
import com.iaito.accounting.repository.BillRepository;
import com.iaito.accounting.service.BillService;


@Service
public class BillServiceImpl implements BillService{
	
	Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired BillRepository billRepository;

	@Override
	public BillDTO getBillById(long billId) {

		return modelMapper.map(billRepository.findById(billId).get(), BillDTO.class);
	}

	@Override
	public List<BillDTO> getAllBills() {

		return billRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, BillDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public BillDTO addBill(Bill bill) {

		bill.setCreateDatetime(new java.util.Date());
		bill.setBillStatus("Draft");
		
		return modelMapper.map(billRepository.save(bill), BillDTO.class);
	}

	@Override
	public BillDTO updateBill(Bill bill) {

		Bill billToUpdate = billRepository.findById(bill.getBillId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(billRepository.save(billToUpdate), BillDTO.class);
	}

	@Override
	public void deleteBill(long billId) {

		billRepository.deleteById(billId);
	}

}
