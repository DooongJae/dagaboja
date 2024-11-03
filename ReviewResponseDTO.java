package com.dagaboja.entity;

import lombok.Getter;

@Getter
public class ReviewResponseDTO {
	private Long customerId;
	private String title;
	private Long viewCount;
	private Long recommend;
	
	public ReviewResponseDTO(Review review) {
		this.customerId = review.getCustomerId();
		this.title = review.getTitle();
		this.viewCount = review.getViewCount();
		this.recommend = review.getRecommend();
	}
	
}
