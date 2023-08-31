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
import org.springframework.web.bind.annotation.RestController;

import com.ims.dtos.CreateInventoryRequestDto;
import com.ims.dtos.DeleteInventoryRequestDto;
import com.ims.dtos.InventoryDto;
import com.ims.dtos.ResponseDto;
import com.ims.dtos.SearchInventoryResponseDto;
import com.ims.dtos.SearchWarehouseResponseDto;
import com.ims.dtos.UpdateInventoryRequestDto;
import com.ims.repositories.InventoryRepository;
import com.ims.services.InventoryServiceImpl;


@RestController
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
	public ResponseEntity<ResponseDto> createInventory( @RequestBody CreateInventoryRequestDto createRequest) {
		ResponseEntity<ResponseDto> result = this.inventoryService.createInventory(createRequest.getItemName(), createRequest.getWarehouseName(), createRequest.getQuantity());
		return result;

	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateInventory(@RequestBody UpdateInventoryRequestDto updateRequest) {
		
		ResponseEntity<ResponseDto> result = this.inventoryService.updateInventory(updateRequest.getInventoryId(), updateRequest.getQuantity());
		return result;

	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteInventory(@RequestParam int inventoryId) {
		
		ResponseEntity<ResponseDto> result = this.inventoryService.deleteInventory(inventoryId);
		return result;

	}
	@GetMapping("/warehouses")
	public ResponseEntity<SearchWarehouseResponseDto> getAll() {
		
		SearchWarehouseResponseDto warehouses = this.inventoryService.getAll();
		
		return new ResponseEntity<SearchWarehouseResponseDto>(warehouses, HttpStatus.OK);

	}
}
