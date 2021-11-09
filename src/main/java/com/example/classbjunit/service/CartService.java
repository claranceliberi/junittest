package com.example.classbjunit.service;

import com.example.classbjunit.model.Cart;
import com.example.classbjunit.model.dto.CartDto;

import java.util.List;

public interface CartService {
    public List<Cart> getAll();
    public Cart create(CartDto cart);
    public Cart getById(Integer id);
    public Cart update(CartDto cart);
    public Cart removeItem(CartDto cart);

}
