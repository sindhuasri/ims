package com.ims.services;

import com.ims.dtos.SearchWarehouseResponseDto;

public interface WarehouseService {
	
	SearchWarehouseResponseDto searchWarehouse(String warehouseName, int warehouseId, int page, int size, String sort);

}
