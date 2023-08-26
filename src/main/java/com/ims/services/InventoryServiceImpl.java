package com.ims.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ims.dtos.SearchInventoryResponseDto;
import com.ims.mapper.InventoryMapper;
import com.ims.models.Inventory;
import com.ims.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository;
	private InventoryMapper mapper;

	public InventoryServiceImpl(InventoryRepository inventoryRepository, InventoryMapper mapper) {
		this.inventoryRepository = inventoryRepository;
		this.mapper = mapper;
	}

	@Override
	public SearchInventoryResponseDto searchInventory(int warehouseId, int page, int size, String sort) {

		try {
			List<Sort.Order> orders = new ArrayList();
			if (sort.contains(",")) {
				String[] sortParts = sort.split(",");
				orders.add(new Sort.Order(this.getSortDirection(sortParts[1]), sortParts[0]));
			}
			Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
			Page<Inventory> inventoriesPage;

			if (warehouseId == 0) {
				inventoriesPage = this.inventoryRepository.findAll(pagingSort);
			} else {
				inventoriesPage = this.inventoryRepository.findByWarehouseId(warehouseId, pagingSort);
			}

			return this.mapper.convert(inventoriesPage);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	private Sort.Direction getSortDirection(String direction) {
		if (direction.equals("asc")) {
			return Direction.ASC;
		} else {
			return direction.equals("desc") ? Direction.DESC : Direction.ASC;
		}
	}

	@Override
	public ResponseEntity<String> createInventory(int itemId, int warehouseId, int quantity) {
		String successMessage = "Inventory created successfully.";
		this.inventoryRepository.saveAndFlush(new Inventory());
		return ResponseEntity.ok(successMessage);
	}
	

	@Override
	public ResponseEntity<String> updateInventory(int inventoryId, int quantity) {
		String successMessage = "Inventory updated successfully.";
		return ResponseEntity.ok(successMessage);

	}

}
