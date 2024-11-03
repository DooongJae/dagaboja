package com.dagaboja.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dagaboja.entity.Customer;
import com.dagaboja.entity.Review;
import com.dagaboja.entity.Store;
import com.dagaboja.repository.CustomerRepository;
import com.dagaboja.repository.ReviewRepository;
import com.dagaboja.repository.StoreRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.dagaboja")
@EntityScan(basePackages = "com.dagaboja.entity")
@EnableJpaRepositories(basePackages = "com.dagaboja.repository")
public class DagabojaApplication  {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired 
	private StoreRepository storeRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DagabojaApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		
		for(int i = 0; i < 100; i++) {
			
			customerRepository.save(
					Customer.builder()
						
			);
			
			storeRepository.save(
					Store.builder()
						.businessId((long) i)
						.storeType("한식")
						.storeName("매장" + i)
						.storeAddress("매장" + i)
						.storeTel("01011111111")
						.totalSeat(i)
						.build()
						
			);
			
			reviewRepository.save(
					
					Review.builder()
						.customerId(i)
						.
					);
		}
		
	} */
	
}  

 

