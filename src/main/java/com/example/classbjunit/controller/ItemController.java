package com.example.classbjunit.controller;

import java.util.List;

import com.example.classbjunit.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.classbjunit.model.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("")
	public List<Item> getAll(){
		
		return itemService.getAll();
	}
	@GetMapping("/test")
	public String test(){
		return "test";
	}
}
