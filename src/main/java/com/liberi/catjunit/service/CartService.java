package com.liberi.catjunit.service;

import com.liberi.catjunit.model.Cart;
import com.liberi.catjunit.model.dto.CartDto;

import java.util.List;

public interface CartService {
    public List<Cart> getAll();
    public Cart create(CartDto cart);
    public Cart getById(Integer id);
    public Cart update(CartDto cart);
    public Cart removeItem(CartDto cart);

}
