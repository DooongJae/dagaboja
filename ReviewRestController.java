package com.dagaboja.controller;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dagaboja.entity.Review;
import com.dagaboja.entity.ReviewListResponseDTO;
import com.dagaboja.entity.ReviewResponseDTO;
import com.dagaboja.entity.Store;
import com.dagaboja.service.ReviewService;
import com.dagaboja.service.StoreService;

@RestController
public class ReviewRestController {
	
	@Autowired
	StoreService storeService;
	
	@Autowired
	ReviewService reviewService;

	@GetMapping("store/detail/{id}/review/{reviewPage}") 
	public ReviewListResponseDTO storeDetailReviewPage(@PathVariable("id") Long id, 
			 @PathVariable("reviewPage") int reviewPage) {
		
		//Store store = storeService.findById(id);

		//Page<Review> reviewPages = reviewService.requestPage(reviewPage);
		
		Page<Review> reviewPages = reviewService.requestPageStoreId(reviewPage, id);
		
		List<ReviewResponseDTO> reviewList = reviewPages.getContent().stream()
				// .map(ReviewResponseDTO::new)
				.map(review ->  new ReviewResponseDTO(review))
				.collect(Collectors.toList());
		
		
		ReviewListResponseDTO reviewListResponseDTO = 
				ReviewListResponseDTO.builder()
					.reviewLists(reviewList)
					.reviewHasNext(reviewPages.hasNext())
					.reviewHasPrevious(reviewPages.hasPrevious())
					.reviewPageNumber(reviewPages.getNumber())
					.reviewTotalPage(reviewPages.getTotalPages())
					.build();
		

		System.out.println("토탈 페이지" + reviewPages.getTotalPages());

		return reviewListResponseDTO;
		
	}
	
}
