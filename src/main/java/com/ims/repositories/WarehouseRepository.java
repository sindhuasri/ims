package com.ims.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ims.models.Warehouse;

public interface WarehouseRepository {
	Page<Warehouse> findAll();

	Page<Warehouse> findByWarehouseId(int WarehouseId, String warehouseName, Pageable pagingSort);

}
