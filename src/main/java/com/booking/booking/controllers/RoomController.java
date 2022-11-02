package com.booking.booking.controllers;

public class RoomController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ArrayList<SerializableOrder> getOrders()
    {
        ArrayList<SerializableOrder> list = new ArrayList<>();
        ArrayList<Order> orders = orderService.retrieveOrders();

        for(Order o : orders)
            list.add(o.getSerializable());

        return list;
    }
}
