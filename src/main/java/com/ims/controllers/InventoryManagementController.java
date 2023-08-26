package com.ims.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ims.dtos.InventoryDto;
import com.ims.dtos.SearchInventoryResponseDto;
import com.ims.repositories.InventoryRepository;
import com.ims.services.InventoryServiceImpl;

@Controller
@RequestMapping("/inventory")
public class InventoryManagementController {

	private InventoryServiceImpl inventoryService;

	public InventoryManagementController(InventoryServiceImpl inventoryService) {
		this.inventoryService = inventoryService;
	}

	@GetMapping("/search")
	public ResponseEntity<SearchInventoryResponseDto> searchInventory(@RequestParam(required = false, defaultValue="0") int warehouseId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "warehouseId,desc") String sort) {

		SearchInventoryResponseDto inventories = this.inventoryService.searchInventory(warehouseId, page, size, sort);

		return new ResponseEntity<SearchInventoryResponseDto>(inventories, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<String> createInventory( @RequestParam int itemID, 
			@RequestParam int warehouseId, 
			@RequestParam int quantity) {

		return ResponseEntity.status(HttpStatus.CREATED).body("New Inventory created successfully");

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateInventory(@RequestParam int inventoryId, 
			@RequestParam int quantity ) {
		return ResponseEntity.status(HttpStatus.OK).body("Inventory updated successfully");

	}

	@DeleteMapping("/delete")
	public void deleteInventory() {

	}

}
