package com.ims.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ims.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	@Query
	
	Page<Inventory> findByWarehouseId(int warehouseId, Pageable pageable);

	//void saveAndFlush();
	
	
	

}
