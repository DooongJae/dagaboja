package com.dagaboja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagaboja.entity.Business;
import com.dagaboja.entity.Customer;
import com.dagaboja.repository.BusinessRepository;
import com.dagaboja.repository.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BusinessService {
	
	@Autowired
	private final BusinessRepository busiCustRepo;
	
	@Autowired
	private final CustomerRepository custRepo;
	
	@Transactional
	public Business registerBusiness(Customer customer, Business businnes) {
		
		custRepo.save(customer); 
		return busiCustRepo.save(businnes);
		
	}
		
}
