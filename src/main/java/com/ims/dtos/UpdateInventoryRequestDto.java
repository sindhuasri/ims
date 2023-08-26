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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inventoryId;
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateInventoryRequestDto other = (UpdateInventoryRequestDto) obj;
		if (inventoryId != other.inventoryId)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UpdateInventoryRequestDto [quantity=" + quantity + ", inventoryId=" + inventoryId + "]";
	}

}
