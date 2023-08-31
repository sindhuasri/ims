package com.ims.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

import com.ims.dtos.ResponseDto;
import com.ims.dtos.SearchInventoryResponseDto;
import com.ims.dtos.SearchWarehouseResponseDto;
import com.ims.mapper.InventoryMapper;
import com.ims.models.Inventory;
import com.ims.models.Item;
import com.ims.models.Warehouse;
import com.ims.models.WarehouseCapacity;
import com.ims.repositories.InventoryRepository;
import com.ims.repositories.ItemRepository;
import com.ims.repositories.WarehouseCapacityRespository;
import com.ims.repositories.WarehouseRepository;



@Service
public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository;
	private WarehouseRepository warehouseRepository;
	private ItemRepository itemRepository;
	private WarehouseCapacityRespository warehouseCapacityRespository;
	
	private InventoryMapper mapper;

	public InventoryServiceImpl(InventoryRepository inventoryRepository, WarehouseRepository warehouseRepository,
			ItemRepository itemRepository, WarehouseCapacityRespository warehouseCapacityRespository, InventoryMapper mapper) {
		this.inventoryRepository = inventoryRepository;
		this.mapper = mapper;
		this.itemRepository = itemRepository;
		this.warehouseRepository = warehouseRepository;
		this.warehouseCapacityRespository = warehouseCapacityRespository;
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
	public ResponseEntity<ResponseDto> createInventory(String itemName, String warehouseName, int quantity) {
		String successMessage = "Inventory created successfully.";
		Warehouse warehouse = this.warehouseRepository.findByName(warehouseName);
		Item item = this.itemRepository.findByName(itemName);
		ResponseDto response = new ResponseDto();
		if (warehouse == null)
		{
			response.setMessage("Warehouse cannot be found!");
			return ResponseEntity.unprocessableEntity().body(response);
		}
		if (item == null)
		{
			response.setMessage("Item cannot be found!");
			return ResponseEntity.unprocessableEntity().body(response);
		}
		Inventory inventory = this.inventoryRepository.findByWarehouseAndItem(warehouse, item);
		if (inventory!= null) {
			response.setMessage("Inventory is already present. Please use update functionality!");
			return ResponseEntity.unprocessableEntity().body(response);
		}
		
		if (CheckCapacity(item.getId(), warehouse.getId(),quantity)) {
			this.inventoryRepository.saveAndFlush(new Inventory(item, warehouse, quantity));
			response.setMessage(successMessage);
			return ResponseEntity.ok(response);
			
		}
		else {
			response.setMessage("Some error occured!");
			return ResponseEntity.unprocessableEntity().body(response);
		}
		
	}
	

	@Override
	public ResponseEntity<ResponseDto> updateInventory(int inventoryId, int quantity) {
		String successMessage = "Inventory updated successfully.";
		Optional<Inventory> optinaIinventory = this.inventoryRepository.findById(inventoryId);
		ResponseDto response = new ResponseDto();
		
		if (optinaIinventory.isPresent())
		{
			Inventory inventory =  optinaIinventory.get();
			if (CheckCapacity(inventory.getItem().getId(), inventory.getWarehouse().getId(),quantity)) {
				inventory.setQuantity(quantity);
				this.inventoryRepository.saveAndFlush(inventory);
				response.setMessage(successMessage);
				return ResponseEntity.ok(response);
			}
			else
			{
				response.setMessage("Warehouse is out of capacity!");
				return ResponseEntity.unprocessableEntity().body(response);
			}
		}
		response.setMessage("Failed to update!");
		return ResponseEntity.unprocessableEntity().body(response);

	}
	@Override
	public ResponseEntity<ResponseDto> deleteInventory(int inventoryId) {
		String successMessage = "Inventory delete successfully.";
		Optional<Inventory> optinaIinventory = this.inventoryRepository.findById(inventoryId);
		ResponseDto response = new ResponseDto();
		
		if (optinaIinventory.isPresent())
		{
			Inventory inventory =  optinaIinventory.get();
			this.inventoryRepository.delete(inventory);
			response.setMessage(successMessage);
			return ResponseEntity.ok(response);

		}
		response.setMessage("Inventory is not available to delete!");
		return ResponseEntity.unprocessableEntity().body(response);

	}
	private boolean CheckCapacity(int itemId, int wahrehouseId, int inputCapacity)
	{
		WarehouseCapacity constraint = this.warehouseCapacityRespository.findByItemIdAndWarehouseId(itemId, wahrehouseId);
		if (constraint != null){
			if (constraint.getMaxLimit() < inputCapacity){
				return false;
			}
		}
		return true;
	}
	@Override
	public SearchWarehouseResponseDto getAll() {

		try {
			List<Warehouse> warehouses = this.warehouseRepository.findAll();

			return this.mapper.convert(warehouses);

		} catch (Exception e) { 
			e.printStackTrace();

		}

		return null;

	}

}
