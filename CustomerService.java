package com.dagaboja.service;

import java.util.Optional;

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
public class CustomerService {
	
	@Autowired
	private final CustomerRepository custRepo;

	public Customer registerCustomer(Customer customer) {
		
		return custRepo.save(customer);
	}
	
}
