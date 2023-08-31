package com.ims.dtos;

public class UpdateInventoryRequestDto {

	private int quantity;
	private int inventoryId;

	public UpdateInventoryRequestDto() {
		super();
	}

	public UpdateInventoryRequestDto(int quantity, int inventoryId) {
		super();
		this.quantity = quantity;
		this.inventoryId = inventoryId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	
}
