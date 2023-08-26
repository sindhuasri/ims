package com.ims.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/capacity")
public class WarehouseCapacityController {
	
	@GetMapping("/search")
	public void searchWarehouseCapacity(@RequestParam(required = false) int warehouseId,
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "warehouseId,desc") String sort){
		
	}
	
	@PostMapping("/create")
		public void createWarehouseCapacity() {
		
	}
	

}