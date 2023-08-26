package com.ims.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ims.services.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	private ItemService itemService;

	@GetMapping("/seach")
	public void searchItem() {

	}

	@PostMapping("/create")
	public void createItem() {

	}

	@PutMapping("/update")
	public void updateItem() {

	}
	
	@DeleteMapping("/delete")
	public void deleteItem() {
		
	}

}
