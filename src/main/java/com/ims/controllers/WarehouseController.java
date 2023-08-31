//package com.ims.controllers;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ims.dtos.SearchInventoryResponseDto;
//import com.ims.dtos.SearchWarehouseResponseDto;
//import com.ims.services.WarehouseService;
//
//@Controller
//@RequestMapping("/warehouse")
//public class WarehouseController {
//
//	private WarehouseService warehouseService;
//
//	public WarehouseController(WarehouseService warehouseService) {
//		this.warehouseService = warehouseService;
//
//		
//	}
//
//	@GetMapping("/getall")
//	public ResponseEntity<SearchWarehouseResponseDto> getAll() {
//		
//		SearchWarehouseResponseDto warehouses = this.warehouseService.getAll();
//		
//		return new ResponseEntity<SearchWarehouseResponseDto>(warehouses, HttpStatus.OK);
//
//	}
//
//}
