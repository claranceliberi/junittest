package com.example.classbjunit.service;

import com.example.classbjunit.model.Item;
import com.example.classbjunit.model.dto.ItemDto;

import java.util.List;

public interface ItemService {
    public List<Item> getAll();
    public Item create(ItemDto itemDto);
    public Item getById(Integer id);
    public Item update(ItemDto itemDto);
}
