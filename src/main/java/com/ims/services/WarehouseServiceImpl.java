package com.ims.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ims.dtos.SearchWarehouseResponseDto;
import com.ims.dtos.WarehouseDto;
import com.ims.mapper.WarehouseMapper;
import com.ims.models.Inventory;
import com.ims.models.Warehouse;
import com.ims.repositories.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	private WarehouseRepository warehouseRepository;
	private WarehouseMapper mapper;

	public WarehouseServiceImpl() {
		super();
	}

	public WarehouseServiceImpl(WarehouseRepository warehouseRepository, WarehouseMapper mapper) {
		super();
		this.warehouseRepository = warehouseRepository;
		this.mapper = mapper;
	}

	@Override
	public SearchWarehouseResponseDto searchWarehouse(String warehouseName, int warehouseId, int page, int size,
			String sort) {

		try {
			List<Sort.Order> orders = new ArrayList<>();

			if (sort.contains(",")) {
				String[] sortParts = sort.split(",");
				orders.add(new Sort.Order(this.getSortDirection(sortParts[1]), sortParts[0]));
			}
			Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

			Page<Warehouse> warehousesPage;

			warehousesPage = this.warehouseRepository.findByWarehouseId(warehouseId, warehouseName, pagingSort);

			return this.mapper.convert(warehousesPage);

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

}
