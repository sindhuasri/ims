package com.ims.services;

import org.springframework.http.ResponseEntity;

import com.ims.dtos.SearchInventoryResponseDto;

public interface InventoryService {
	
	SearchInventoryResponseDto searchInventory(int warehouseId, int page, int size, String sort);
	ResponseEntity<String> createInventory(int itemId, int warehouseId, int quantity);
	ResponseEntity<String> updateInventory(int inventoryId, int quantity);	
	
}
