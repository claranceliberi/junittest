package com.liberi.catjunit.model.dto;

import com.liberi.catjunit.model.Cart;

public class CartDto {
    private int id;
    private String items;

    public CartDto() {
    }

    public CartDto(int id, String items) {
        this.id = id;
        this.items = items;
    }
    public CartDto(int id) {
        this.id = id;
    }

    public Cart toCart(){
        return new Cart(this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
