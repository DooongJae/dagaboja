package com.dagaboja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dagaboja.entity.Review;
import com.dagaboja.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private final ReviewService reviewService;

	@GetMapping("write-form/{id}")
	public String writeForm(@PathVariable("id") Long id) {
		
		
		return "review_write_form";
		
	}
	
	
	@PostMapping("register/{id}")
	public String registerReview(@PathVariable("id") Long id, Review review) {
	
		review = review.toBuilder()
			.customerId(1l)
			.storeId(id)
			.category("엄")
		.build();

		System.out.println(review);
		reviewService.registerReview(review);
		
		
		return "redirect:/store/detail/{id}#myTable";
		
	}
	
	
	
	

	
	
	
	
}
