package com.ims.dtos;


public class CreateInventoryRequestDto {

	private int itemId;
	private int warehouseId;
	private int quantity;
	
	public CreateInventoryRequestDto() {
		super();
	}

	public CreateInventoryRequestDto(int itemId, int warehouseId, int quantity) {
		super();
		this.itemId = itemId;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + quantity;
		result = prime * result + warehouseId;
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
		CreateInventoryRequestDto other = (CreateInventoryRequestDto) obj;
		if (itemId != other.itemId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (warehouseId != other.warehouseId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreateInventoryRequestDto [itemId=" + itemId + ", warehouseId=" + warehouseId + ", quantity=" + quantity
				+ "]";
	}
	
	
	
	
}
