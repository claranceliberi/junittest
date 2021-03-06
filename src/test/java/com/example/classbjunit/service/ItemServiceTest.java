package com.example.classbjunit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import com.example.classbjunit.model.dto.ItemDto;
import com.example.classbjunit.service.impl.ItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.classbjunit.model.Item;
import com.example.classbjunit.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {


	@Mock
	private ItemRepository itemRepositoryMock;
	
	@InjectMocks
	private ItemServiceImpl itemService;
	
	@Test
	public void getAll_withSomeElements() {

		when(itemRepositoryMock.findAll()).thenReturn(Arrays.asList(new Item(1,"Samuel",1,10),
				new Item(2,"Blessing",4,100)));
		assertEquals(10,itemService.getAll().get(0).getValue());
	}

	@Test
	public void createItem_success() {
		ItemDto itemDto = new ItemDto(1,"Liberi",100,10);
		when(itemRepositoryMock.save(ArgumentMatchers.any(Item.class))).thenReturn(itemDto.toItem());
		assertEquals(1000, itemService.create(itemDto).getValue());
	}

	@Test
	public void updateItem_success() {
		ItemDto itemDto = new ItemDto(1,"Liberi",120,10);
		Item searched = itemDto.toItem();
		searched.setValue(itemDto.getQuantity()*itemDto.getPrice());
		when(itemRepositoryMock.findById(itemDto.getId())).thenReturn(Optional.of(searched));

		Item updateItem = itemDto.toItem();
		updateItem.setValue(itemDto.getQuantity()*itemDto.getPrice());
		itemDto.setPrice(150);
		updateItem.setPrice(150);

		when(itemRepositoryMock.save(ArgumentMatchers.any(Item.class))).thenReturn(updateItem);
		assertEquals(1500,itemService.update(itemDto).getValue());
	}

	@Test
	public void findById_success() {
		when(itemRepositoryMock.findById(2)).thenReturn(Optional.of(new Item(1,"Samuel",1,10)));
		assertEquals(10,itemService.getById(2).getValue());
	}

}
