package com.dagaboja.controller;

import java.awt.DefaultFocusTraversalPolicy;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dagaboja.entity.Business;
import com.dagaboja.entity.Customer;
import com.dagaboja.entity.Review;
import com.dagaboja.entity.Store;
import com.dagaboja.entity.StoreRegisterRequestDTO;
import com.dagaboja.entity.StoreRegisterRequestDTO;
import com.dagaboja.service.BusinessService;
import com.dagaboja.service.CustomerService;
import com.dagaboja.service.ReviewService;
import com.dagaboja.service.StoreService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	@Autowired
	private final CustomerService custService;
	
	@Autowired
	private final BusinessService busiService;
	
	@Autowired
	private final StoreService storeService;
	
	@Autowired
	private final ReviewService reviewService;

	// 메인 페이지
	@GetMapping("index")
	public String index(Model model ,@RequestParam(defaultValue = "0") int page) {
		 
		Page<Store> pages = storeService.requestPage(page);

		model.addAttribute("pages", pages);
		return "index";
	}
	
	@GetMapping("cust-and-busi/register-form")
	public String signup() {
		
		return "customer_and_business_register_form";
	}
	
	@GetMapping("cust-and-busi/index")
	public String backIndex() {
		
		return "redirect:/index";
	}
	
	@GetMapping("cust-and-busi/store_register_form")
	public String moveStoreRegisterForm() {
		
		return "redirect:/store/register-form";
	}

	@PostMapping("customer/register")
	public String registerCustomer(Customer customer) {
		
		System.out.println(custService.registerCustomer(customer));
		
		return "redirect:/index";
	}
	

	@PostMapping("business/register")
	public String registerBusiness(Customer customer, Business business) {
		
		System.out.println(busiService.registerBusiness(customer, business));
		return "redirect:/index";
		
	} 

	@GetMapping("store/register-form")
	public String storeRegisterForm() {
		
		return "store_register_form";
		
	}
	
	private static final String UPLOAD_DIR  
	= "C:\\\\Users\\admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\"
			+ "dagabojaBoot\\src\\main\\resources\\static\\images\\";
	
	@PostMapping("store/register") 
	public String registerStore(StoreRegisterRequestDTO srDTO, @RequestParam("image") MultipartFile[] files) {
		
		// TODO 로그인시 자동으로 id가 들어가게
		System.out.println("test"+files);
		
		Store store = new Store();
		
		BeanUtils.copyProperties(srDTO, store);
		
		// 여러거 저장된 이미지들을 append 하기위해 사용 String 사용해도 무관
		StringBuffer result = new StringBuffer("Uploaded files: ");
		
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				
				// 랜덤 파일명 + 원본 파일명
				String fileName = file.getOriginalFilename();
				
				store.setImages(fileName);
				
				// 저장될 파일 위치
				File dest = new File(UPLOAD_DIR + fileName);
				
				// 폴더가 없으면 생성
				if(!dest.exists()) {
					dest.mkdirs();
				}
				
				try {
					file.transferTo(dest); // 저장
					result.append(fileName).append(" , "); // 단순 저장된 파일을 보기위해 사용
				} catch (IOException e) {
					return "Failed to upload " + file.getOriginalFilename() + ": " + e.getMessage();
				}
			}
		}
		
		store.setBusinessId(1l);
		System.out.println(store);
		
		System.out.println(storeService.registerStore(store));
		
		
		return "redirect:/index";
		
	} 

	
	@GetMapping("store/detail/{id}") 
	public String storeDetail(@PathVariable("id") Long id, Model model, @RequestParam(defaultValue = "0") int reviewPage) {
		 
		Store store = storeService.findById(id);
		model.addAttribute("store", store); 

		return "store_detail";
		
	}
	
	/*
	
	@GetMapping("store/detail/{id}/review/{reviewPage}") 
	public String storeDetailReviewPage(@PathVariable("id") Long id, Model model, 
			 @PathVariable("reviewPage") int reviewPage) {
		
		System.out.println(reviewPage);
		Store store = storeService.findById(id);
		model.addAttribute("store", store);

		
		List<Review> reviewList = reviewService.findByStoreId(id);
		model.addAttribute("reviewList",  reviewList);
		

		Page<Review> reviewPages = reviewService.requestPage(reviewPage);
		model.addAttribute("reviewPages", reviewPages);
		System.out.println("토탈 페이지" + reviewPages.getTotalPages());
		
		return "store_detail";
		
	}
	
	 */

	  
}

