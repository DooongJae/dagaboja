package com.dagaboja.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)

@Entity
@Table(name="business")
@DynamicInsert
@DynamicUpdate
public class Business {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "customerId", unique = true, nullable = false, insertable = false, updatable = false)
	private Customer customer;
	
	@Column(name = "customerId")
	private Long customerId;
	
	@Column(length = 10, unique = true, nullable = false)
	private String businessRegistrationNumber;
	
	public void updateOwner(Business business) {
		if(business.getBusinessRegistrationNumber() != null) this.businessRegistrationNumber = business.getBusinessRegistrationNumber();
	}
	
}
