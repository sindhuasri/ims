package com.ims.dtos;


public class CreateInventoryRequestDto {

	private String itemName;
	private String warehouseName;
	private int quantity;
	
	public CreateInventoryRequestDto() {
		super();
	}

	public CreateInventoryRequestDto(String itemName, String warehouseName, int quantity) {
		super();
		this.itemName = itemName;
		this.warehouseName = warehouseName;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemId(String itemName) {
		this.itemName = itemName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseId(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
}
