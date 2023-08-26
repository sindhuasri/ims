package com.ims.dtos;

public class InventoryDto {
	private int itemId;
	private int warehouseId;
	private int quantity;
	private String warehouseName;
	private String itemName;
	private int inventoryId;
	
	public InventoryDto() {
		super();
	}

	public InventoryDto(int inventoryId,int itemId, int warehouseId, int quantity, 
			String warehouseName, String itemName) {
		super();
		this.inventoryId = inventoryId;
		this.itemId = itemId;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
		this.warehouseName = warehouseName;
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
