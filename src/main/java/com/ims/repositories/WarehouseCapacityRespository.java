package com.ims.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ims.models.WarehouseCapacity;


public interface WarehouseCapacityRespository extends JpaRepository<WarehouseCapacity, Integer>{

	WarehouseCapacity findByItemIdAndWarehouseId(int itemId, int warehouseId);

}
