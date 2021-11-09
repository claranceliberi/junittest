package com.liberi.catjunit.service;

import com.liberi.catjunit.model.Item;
import com.liberi.catjunit.model.dto.ItemDto;

import java.util.List;

public interface ItemService {
    public List<Item> getAll();
    public Item create(ItemDto itemDto);
    public Item getById(Integer id);
    public Item update(ItemDto itemDto);
}
