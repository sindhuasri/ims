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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inventoryId;
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
		DeleteInventoryRequestDto other = (DeleteInventoryRequestDto) obj;
		if (inventoryId != other.inventoryId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeleteInventoryRequestDto [inventoryId=" + inventoryId + "]";
	}
	
	
	
	

}
