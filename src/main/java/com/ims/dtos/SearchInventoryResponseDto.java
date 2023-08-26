package com.ims.dtos;

import java.util.List;

public class SearchInventoryResponseDto extends PageDto {

	List<InventoryDto> inventories;

	public List<InventoryDto> getInventories() {
		return inventories;
	}

	public void setInventories(List<InventoryDto> inventories) {
		this.inventories = inventories;
	}
}
