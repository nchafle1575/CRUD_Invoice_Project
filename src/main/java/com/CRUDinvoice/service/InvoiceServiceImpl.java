package com.CRUDinvoice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUDinvoice.entities.Invoice;
import com.CRUDinvoice.exception.InvoiceNotFoundException;
import com.CRUDinvoice.repository.InvoiceRepository;
import com.CRUDinvoice.util.InvoiceUtil;
@Service 
public class InvoiceServiceImpl implements IInvoiceService {

	
	@Autowired
	private InvoiceRepository repo;  
	
	@Autowired
	private InvoiceUtil util;
	
	
	@Override
	public Long saveInvoice(Invoice inv) {

		util.CalculateFinalAmountIncludingGST(inv);
		Long id = repo.save(inv).getId();
		return id;
	}

	@Override
	public void updateInvoice(Invoice inv) {
		// TODO Auto-generated method stub
		
		util.CalculateFinalAmountIncludingGST(inv);
		repo.save(inv);
		
	}

	@Override
	public void deleteInvoice(Long id) {
		// TODO Auto-generated method stub
		Invoice inv = getOneInvoice(id);
		repo.delete(inv);
		
	}
	
	public Optional<Invoice> getSingleInvoice(Long Id) {
		return repo.findById(Id);
	}
	

	@Override
	public Invoice getOneInvoice(Long id) {


		Invoice inv = repo.findById(id)
				.orElseThrow(()->new InvoiceNotFoundException(
						new StringBuffer().append("Product  '")
						.append(id)
						.append("' not exist")
						.toString())
						);
		
		return inv;
	}

	@Override
	public List<Invoice> getAllInvoices() {
		List<Invoice> list = repo.findAll();
		 return list;
	}

	@Override
	public boolean isInvoiceExist(Long id) {
		 
		return repo.existsById(id);
	}

	@Override
	@Transactional
	public Integer updateInvoiceNumberById(String number, Long id) {


		if(!repo.existsById(id)) {
			throw new InvoiceNotFoundException(
					new StringBuffer()
					.append("Invoice '")
					.append(id)
					.append("' not exist")
					.toString());
		}
		
		return repo.updateInvoiceNumberById(number, id);
	}

}
