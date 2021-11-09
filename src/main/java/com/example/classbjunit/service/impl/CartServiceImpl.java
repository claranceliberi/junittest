package com.example.classbjunit.service.impl;

import com.example.classbjunit.model.Cart;
import com.example.classbjunit.model.Item;
import com.example.classbjunit.model.dto.CartDto;
import com.example.classbjunit.repository.CartRepository;
import com.example.classbjunit.repository.ItemRepository;
import com.example.classbjunit.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart create(CartDto cartDto) {
        Cart savedCart = cartRepository.save(cartDto.toCart());
        savedCart.setTotalPrice(0);
        System.out.println(savedCart);
        return savedCart;
    }

    @Override
    public Cart getById(Integer id) {
        Optional<Cart> cart = cartRepository.findById(id);
        Cart savedCart = cart.get();

        if(savedCart.getItems() == null)
            savedCart.setTotalPrice(0);
        else {
            for(Item item : savedCart.getItems()){
                savedCart.setTotalPrice(savedCart.getTotalPrice() + (item.getPrice() * item.getQuantity()));
            }
        }

        return savedCart;
    }

    @Override
    public Cart update(CartDto cartDto) {
        Cart cart = getById(cartDto.getId());
        Set<Item> items = new HashSet<>();

        for(String itemId: cartDto.getItems().split(",")){
            Optional<Item> item = itemRepository.findById(Integer.parseInt(itemId));
            if(!item.isPresent()){
                items.add(item.get());
            }
        }

        cart.setItems(items);
        Cart savedCart = cartRepository.save(cart);

        for(Item item : savedCart.getItems()){
            savedCart.setTotalPrice(savedCart.getTotalPrice() + (item.getPrice() * item.getQuantity()));
        }

        return savedCart;
    }

    @Override
    public Cart removeItem(CartDto cartDto) {
        Cart cart = getById(cartDto.getId());

        Set<Item> items = cart.getItems();

        if(items != null){
            for(String itemId: cartDto.getItems().split(",")){
                Optional<Item> item = itemRepository.findById(Integer.parseInt(itemId));
                item.ifPresent(items::remove);
            }
        }

        cart.setItems(items);
        Cart savedCart = cartRepository.save(cart);

        for(Item item : savedCart.getItems()){
            savedCart.setTotalPrice(savedCart.getTotalPrice() + (item.getPrice() * item.getQuantity()));
        }

        return savedCart;
    }
}
