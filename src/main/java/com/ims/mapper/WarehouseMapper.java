package com.ims.mapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.ims.dtos.SearchWarehouseResponseDto;
import com.ims.dtos.WarehouseDto;
import com.ims.models.Warehouse;

@Component
public class WarehouseMapper {

	// convert a Warehouse Entity into a WarehouseDto

	public SearchWarehouseResponseDto convert(Page<Warehouse> warehousesPage) {
		return new SearchWarehouseResponseDto();
	}
		
		
	//convert a WarehouseEntity to a WarehouseDto

	public SearchWarehouseResponseDto convert(WarehouseDto warehouseDto) {
		return new SearchWarehouseResponseDto();
	}

}
