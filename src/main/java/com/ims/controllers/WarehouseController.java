package com.ims.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ims.dtos.SearchInventoryResponseDto;
import com.ims.dtos.SearchWarehouseResponseDto;
import com.ims.services.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

	private WarehouseService warehouseService;

	public WarehouseController(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;

	}

	@GetMapping("/search")
	public ResponseEntity<SearchWarehouseResponseDto> searchWarehouse(
			@RequestParam String warehouseName, 
			@RequestParam int warehouseId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "warehouseId,desc") String sort) {
		
		SearchWarehouseResponseDto warehouses = this.warehouseService.searchWarehouse(warehouseName, warehouseId, page, size, sort);
		
		return new ResponseEntity<SearchWarehouseResponseDto>(warehouses, HttpStatus.OK);

	}

}
