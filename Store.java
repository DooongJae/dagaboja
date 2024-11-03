package com.dagaboja.entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Builder(toBuilder = true)

@Entity
@Table(name = "store")
@DynamicUpdate
@DynamicInsert
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId;
	
//	@ManyToOne
//	@JoinColumn(name = "owner_id", nullable = false)
//	private Owner owner;
	
	@Column(nullable = false)
	private Long businessId;
	
	@Column(length = 20, nullable = false)
	private String storeType;
	
	@Column(length = 20, nullable = false)
	private String storeName;
	
	@Column(length = 50, nullable = false)
	private String storeAddress;
	
	@Column(length = 11, nullable = false)
	private String storeTel;
	
	@Column(nullable = false)
	private Integer totalSeat;
	
	@Column
	private String images;
	
	@Column
	private String preview;
	
	@Column
	private String comfort;
	
	@Column
	private String hashtag;
	
	@Column(columnDefinition = "tinyint(1) default 1")
	private Byte isActive;
	

	
	
//	@OneToMany(mappedBy = "store")
//	@Builder.Default
//	private List<StoreReservation> storeReservation = new ArrayList<>();
	
	public void updateStore(Store store) {
		
		if(store.getStoreType() != null) this.storeType = store.getStoreType();
		if(store.getStoreName() != null) this.storeName = store.getStoreName();
		if(store.getStoreAddress() != null) this.storeAddress = store.getStoreAddress();
		if(store.getStoreTel() != null) this.storeTel = store.getStoreTel();
		if(store.getTotalSeat() != 0) this.totalSeat = store.getTotalSeat();
		if(store.getPreview() != null) this.preview = store.getPreview();
		if(store.getComfort() != null) this.comfort = store.getComfort();
		if(store.getHashtag() != null) this.hashtag = store.getHashtag();
		if(store.getIsActive() != null) this.isActive = store.getIsActive();
		
	}
	
}
