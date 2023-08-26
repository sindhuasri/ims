package com.ims.dtos;

public class WarehouseDto {

	private int WarehouseId;
	private String WarehouseName;
	private String location;
	private String description;
	private int maxLimit;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}

	public WarehouseDto() {
		super();
	}

	public WarehouseDto(int warehouseId, String warehouseName) {
		super();
		WarehouseId = warehouseId;
		WarehouseName = warehouseName;
	}

	public int getWarehouseId() {
		return WarehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		WarehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return WarehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		WarehouseName = warehouseName;
	}

}
