package com.booking.booking.models.serializable;

public class SerializableRoom {
    private String objectId;
    private double amount;
    private @Nullable ArrayList<CartItem> products;
    private @Nullable  Address address;
    private String status;
}
