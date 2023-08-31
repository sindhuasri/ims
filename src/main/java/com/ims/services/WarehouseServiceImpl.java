//package com.ims.services;
//
//
//import java.util.List;
//import org.springframework.stereotype.Service;
//import com.ims.dtos.SearchWarehouseResponseDto;
//import com.ims.mapper.WarehouseMapper;
//import com.ims.models.Warehouse;
//import com.ims.repositories.WarehouseRepository;
//
//@Service
//public class WarehouseServiceImpl implements WarehouseService {
//
//	private WarehouseRepository warehouseRepository;
//	private WarehouseMapper mapper;
//
//	public WarehouseServiceImpl() {
//		super();
//	}
//
//	public WarehouseServiceImpl(WarehouseRepository warehouseRepository, WarehouseMapper mapper) {
//		super();
//		this.warehouseRepository = warehouseRepository;
//		this.mapper = mapper;
//	}
//
//	@Override
//	public SearchWarehouseResponseDto getAll() {
//
//		try {
//			List<Warehouse> warehouses = this.warehouseRepository.findAll();
//
//			return this.mapper.convert(warehouses);
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//
//		}
//
//		return null;
//
//	}
//
//}
