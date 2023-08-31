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
public class WarehouseMapper {

	// convert a Warehouse Entity into a WarehouseDto

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
