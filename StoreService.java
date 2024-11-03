package com.dagaboja.service;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dagaboja.entity.Business;
import com.dagaboja.entity.Customer;
import com.dagaboja.entity.Store;
import com.dagaboja.repository.BusinessRepository;
import com.dagaboja.repository.CustomerRepository;
import com.dagaboja.repository.StoreRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StoreService {
	
	@Autowired
	private final StoreRepository storeRepo;
	
	public Store registerStore(Store store) {
		
		return storeRepo.save(store);
		
	}

	public List<Store> findAll() {
		
		return storeRepo.findAll();
	}

	public Page<Store> requestPage(int page) {
		
		Pageable pageable = PageRequest.of(page, 12);
		return storeRepo.findAll(pageable);
		
	}

	public Store findById(Long id) {
		
		return storeRepo.findById(id).get();
	}
	
	
	
}
