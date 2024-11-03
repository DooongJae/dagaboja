package com.dagaboja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dagaboja.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	
}
