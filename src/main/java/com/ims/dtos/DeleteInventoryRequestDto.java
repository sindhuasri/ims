package com.ims.dtos;

public class DeleteInventoryRequestDto {
		
	private int inventoryId;

	public DeleteInventoryRequestDto() {
		super();
	}

	public DeleteInventoryRequestDto(int inventoryId) {
		super();
		this.inventoryId = inventoryId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

}
