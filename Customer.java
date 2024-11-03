package com.dagaboja.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
@Builder(toBuilder = true)

@Entity
@Table(name="customer")
@DynamicInsert
@DynamicUpdate
public class Customer implements Serializable{
 
	private static final long serialVersionUID = 8395804870299896446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@Column(unique = true, length = 20, nullable = false)
	private String id;
	
	@Column(length = 32, nullable = false)
	private String password;
	
	@Column(length = 16, nullable = false)
	private String name;
	
	@Column(length = 13, nullable = false)
	private String tel;
	
	@Column(length = 20, nullable = false)
	private String email;
	
	// 0 = 여자, 1 = 남자
	@Column(length = 1, nullable = false)
	private Byte gender;
	
	@CreationTimestamp
	@Column(nullable = false)
	private Timestamp signupDate;
	
	@Column(nullable = false)
	private Date birth;
	
	@Column(length = 100)
	private String preference;
	
	// 1이면 활성화, 0이면 비활성화 = 탈퇴 상태
	@Column(columnDefinition = "tinyint(1) default 1")
	private Integer isActive;

	public void updateCustomer(Customer customer) {
		
		if(customer.getPassword() != null) this.password = customer.getPassword();
		if(customer.getName() != null) this.name = customer.getName();
		if(customer.getTel() != null) this.tel = customer.getTel();
		if(customer.getEmail() != null) this.email = customer.getEmail();
		if(customer.getPreference() != null) this.preference = customer.getPreference();
	}
	
}