package com.liberi.catjunit.service.impl;


import com.liberi.catjunit.model.Cart;
import com.liberi.catjunit.model.Item;
import com.liberi.catjunit.model.dto.CartDto;
import com.liberi.catjunit.repository.CartRepository;
import com.liberi.catjunit.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CartServiceImplTest {

    @Mock
    private CartRepository cartRepositoryMock;
    @Mock
    private ItemRepository itemRepositoryMock;


    @InjectMocks
    private CartServiceImpl cartService;


    @Test
    public void createCart_withNoItems() {
        CartDto cartDto = new CartDto(1);
        when(cartRepositoryMock.save(ArgumentMatchers.any(Cart.class)))
                .thenReturn(cartDto.toCart());

        assertNull(cartService.create(cartDto).getItems());
    }

    @Test
    public void addItems_success() {
        CartDto cartDto = new CartDto(1,"1,2");

        Set<Item> items = new HashSet<>();
        items.add(new Item(1,"Apple",500,10));
        items.add(new Item(2,"Mango",5,5));

        when(cartRepositoryMock.findById(cartDto.getId()))
                .thenReturn(Optional.of(cartDto.toCart()));
        when(itemRepositoryMock.findById(1)).thenReturn(Optional.of(new Item(1,"Apple",500,10)));
        when(itemRepositoryMock.findById(2)).thenReturn(Optional.of(new Item(2,"Mango",5,5)));

        Cart cart = new Cart(1);
        cart.setItems(items);

        when(cartRepositoryMock.save(ArgumentMatchers.any(Cart.class)))
                .thenReturn(cart);

        assertEquals(5025,cartService.update(cartDto).getTotalPrice());
    }

    @Test
    public void removeItems_success() {
        CartDto cartDto = new CartDto(1,"2");
        Item item = new Item(2,"Mango",5,5);
        Set<Item> items = new HashSet<>();
        items.add(new Item(1,"Apple",500,10));
        items.add(item);

        Cart cart = cartDto.toCart();
        cart.setItems(items);


        when(cartRepositoryMock.findById(cartDto.getId()))
                .thenReturn(Optional.of(cart));
        when(itemRepositoryMock.findById(2)).thenReturn(Optional.of(item));

        Cart cartToSave = new Cart(1);
        items.remove(item);
        cartToSave.setItems(items);

        when(cartRepositoryMock.save(ArgumentMatchers.any(Cart.class)))
                .thenReturn(cartToSave);

        assertEquals(5000,cartService.removeItem(cartDto).getTotalPrice());
    }


}