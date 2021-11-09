package com.liberi.catjunit.service.impl;

import java.util.List;
import java.util.Optional;

import com.liberi.catjunit.model.dto.ItemDto;
import com.liberi.catjunit.service.ItemService;
import com.liberi.catjunit.model.Item;
import com.liberi.catjunit.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAll() {
		
		List<Item> items = itemRepository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getQuantity()*item.getPrice());
		}
		
		return items;
	}

	@Override
	public Item create(ItemDto itemDto) {
		Item item = itemRepository.save(itemDto.toItem());
		item.setValue(item.getQuantity()*item.getPrice());
		return item;
	}

	@Override
	public Item getById(Integer id) {
		Optional<Item> itemOp =  itemRepository.findById(id);
		Item item = itemOp.get();
		item.setValue(item.getQuantity()*item.getPrice());
		return item;
	}

	@Override
	public Item update(ItemDto itemDto) {

//		Item item = itemRepository.save(itemDto.toItem());
		Item item = getById(itemDto.getId());

		item.setName(itemDto.getName());
		item.setPrice(itemDto.getPrice());
		item.setQuantity(itemDto.getQuantity());

		Item savedItem = itemRepository.save(item);
		savedItem.setValue(item.getQuantity()*item.getPrice());
		return savedItem;
	}

}
