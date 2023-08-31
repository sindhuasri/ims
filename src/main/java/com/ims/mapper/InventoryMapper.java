package com.ims.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ims.dtos.InventoryDto;
import com.ims.dtos.SearchInventoryResponseDto;
import com.ims.dtos.SearchWarehouseResponseDto;
import com.ims.dtos.WarehouseDto;
import com.ims.models.Inventory;
import com.ims.models.Item;
import com.ims.models.Warehouse;

@Component
public class InventoryMapper {
	
	public SearchInventoryResponseDto convert(Page<Inventory> inventoryPage) {
		SearchInventoryResponseDto result = new SearchInventoryResponseDto();
		List<Inventory> inventories = inventoryPage.getContent();
		List<InventoryDto> inventoryDtos = inventories.stream().map(data ->convert(data)).collect(Collectors.toList());
		result.setInventories(inventoryDtos);
		result.setCurrentPage(inventoryPage.getNumber());
		result.setTotalPages(inventoryPage.getTotalPages());
		result.setTotalItems(inventoryPage.getTotalElements());
		return result;
		
	}
	
	public InventoryDto convert(Inventory inventory)
	{
		Item item = inventory.getItem();
		Warehouse warehouse = inventory.getWarehouse();
		return new InventoryDto(inventory.getId(), item.getId(),warehouse.getId(),
				inventory.getQuantity(),warehouse.getName(),item.getName());
	}
	public SearchWarehouseResponseDto convert(List<Warehouse> warehouses) {
		SearchWarehouseResponseDto result = new SearchWarehouseResponseDto();
		List<WarehouseDto> warehouseDtos = warehouses.stream().map(data ->convert(data)).collect(Collectors.toList());
		result.setWarehouses(warehouseDtos);
		return result;
	}
	
		
	//convert a WarehouseEntity to a WarehouseDto

	public WarehouseDto convert(Warehouse warehouse) {
		return new WarehouseDto(warehouse.getId(),warehouse.getName());
	}
}
