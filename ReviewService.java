package com.dagaboja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dagaboja.entity.Review;
import com.dagaboja.entity.Store;
import com.dagaboja.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

	@Autowired
	private final ReviewRepository reviewRepo;

	public Review registerReview(Review board) {
		
		return reviewRepo.save(board);
		
	}

	public List<Review> findByStoreId(Long storeId) {
		
		 return reviewRepo.findByStoreId(storeId);
		
	}

	public Page<Review> requestPageStoreId(int reviewPage, Long storeId) {

		Pageable pageable = PageRequest.of(reviewPage, 5);
		
		return reviewRepo.findAllByStoreIdOrderByReviewIdDesc(storeId, pageable);
		
	}
	
}
