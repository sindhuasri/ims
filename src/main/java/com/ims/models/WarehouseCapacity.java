package com.ims.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name ="warehousecapacities")
@Table
public class WarehouseCapacity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int maxLimit;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@ManyToOne
	@JoinColumn
	private Item item;
	
	@ManyToOne
	@JoinColumn
	private Warehouse warehouse;
	

	public WarehouseCapacity() {
		super();
	}

	public WarehouseCapacity(int id, int maxLimit,Warehouse warehouse, Item item) {
		super();
		this.id = id;
		this.maxLimit = maxLimit;
		this.warehouse = warehouse;
		this.item = item;
	}

	

}
