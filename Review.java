package com.dagaboja.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "review")
@DynamicInsert
@DynamicUpdate

public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId; 
	
//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = false)
//	private User user; 
	
	@Column(nullable = false)
	private Long customerId; 

//	@ManyToOne
//	@JoinColumn(name = "store_id", nullable = false)
//	private Store store;
	
	@Column(nullable = false)
	private Long storeId;
	
	@Column(length = 20, nullable = false)
	private String category;

	@Column
	private Long parentNo;

	@Column(columnDefinition = "int unsigned default 0")
	private Long viewCount;
	
	@Column(length = 50, nullable = false)
	private String title;
	
	@Column(length = 65536, nullable = false)
	private String content;
	
	@Column(length = 100)
	private String file;
	
	@Column
	private Long cost;

	@Column(columnDefinition = "int unsigned default 0")
	private Long recommend;
	
	
	
}
