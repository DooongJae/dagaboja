package com.dagaboja.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRegisterRequestDTO {
	private Long storeId;
	
//	@ManyToOne
//	@JoinColumn(name = "owner_id", nullable = false)
//	private Owner owner;

	private Long businessId;
	
	private String storeType;
	
	private String storeName;

	private String storeAddress;
	
	private String storeTel;
	
	private Integer totalSeat;
	
	private String preview;
	
	private String comfort;

	private String hashtag;
	
	private Byte isActive;
	

	
	
//	@OneToMany(mappedBy = "store")
//	@Builder.Default
//	private List<StoreReservation> storeReservation = new ArrayList<>();
	/*
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
	*/
}
