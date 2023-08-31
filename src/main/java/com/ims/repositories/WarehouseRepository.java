package com.ims.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ims.models.Warehouse;


@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer>{
	@Query
	Warehouse findByName(String name );

}
