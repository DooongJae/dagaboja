package com.dagaboja.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dagaboja.entity.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByStoreId(Long storeId);

	Page<Review> findAllByStoreIdOrderByReviewIdDesc(Long storeId, Pageable pageable);
	
	
	
}
