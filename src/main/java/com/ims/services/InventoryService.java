package com.ims.services;

import org.springframework.http.ResponseEntity;

import com.ims.dtos.ResponseDto;
import com.ims.dtos.SearchInventoryResponseDto;
import com.ims.dtos.SearchWarehouseResponseDto;

public interface InventoryService {
	
	SearchInventoryResponseDto searchInventory(int warehouseId, int page, int size, String sort);
	ResponseEntity<ResponseDto> createInventory(String itemName, String warehouseName, int quantity);
	ResponseEntity<ResponseDto> updateInventory(int inventoryId, int quantity);
	ResponseEntity<ResponseDto> deleteInventory(int inventoryId);	
	SearchWarehouseResponseDto getAll();
	
}
