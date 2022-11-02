package com.booking.booking.controllers;

public class UserController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public ArrayList<SerializableCart> getCarts()
    {
        ArrayList<SerializableCart> list = new ArrayList<>();
        ArrayList<Cart> carts = cartService.retrieveCarts();

        for(Cart c : carts)
            list.add(c.getSerializable());

        return list;
    }
}
