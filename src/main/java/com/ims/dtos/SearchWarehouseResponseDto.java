package com.ims.dtos;

import java.util.List;

public class SearchWarehouseResponseDto extends PageDto {

	List<WarehouseDto> warehouses;

	public List<WarehouseDto> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<WarehouseDto> warehouses) {
		this.warehouses = warehouses;

	}

}
