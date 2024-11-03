package com.dagaboja.entity;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ReviewListResponseDTO {
	
	List<ReviewResponseDTO> reviewLists;
	boolean reviewHasNext;
	boolean reviewHasPrevious;
	int reviewPageNumber;
	int reviewTotalPage;
	
	
	

	@Builder
	public ReviewListResponseDTO(List<ReviewResponseDTO> reviewLists, boolean reviewHasNext, boolean reviewHasPrevious,
			int reviewPageNumber, int reviewTotalPage) {
	
		this.reviewLists = reviewLists;
		this.reviewHasNext = reviewHasNext;
		this.reviewHasPrevious = reviewHasPrevious;
		this.reviewPageNumber = reviewPageNumber;
		this.reviewTotalPage = reviewTotalPage;
		
	}

}






















