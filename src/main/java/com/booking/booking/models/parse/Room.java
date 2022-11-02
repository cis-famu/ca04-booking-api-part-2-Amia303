package com.booking.booking.models.parse;

public class Room {  final static String AMOUNT = "amount";
    final static String ADDRESS = "address";
    final static String PRODUCTS = "products";
    final static String STATUS = "status";

    public double getAmount() {
        return getDouble(AMOUNT);
    }
    public void setAmount(double amount) {
        put(AMOUNT, amount);
    }
    public ArrayList<CartItem> getProducts()
    {
        return (ArrayList<CartItem>) get(PRODUCTS);
    }
    public void setProducts(ArrayList<CartItem> products)
    {
        JSONArray items = new JSONArray();
        for(CartItem c : products)
            items.put(c.getJSONObject());

        put(PRODUCTS, items);
    }

    public Address getAddress()
    {
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(get(ADDRESS));
        return gson.fromJson(jsonElement, Address.class);
    }
    public void setAddress(Address add)
    {
        put(ADDRESS, add);
    }

    public String getStatus()
    {
        return getString(STATUS);
    }

    public void setStatus(String status)
    {
        put(STATUS, status);
    }


    public SerializableOrder getSerializable() {
        return new SerializableOrder(getObjectId(), getAmount(), getProducts(), getAddress(), getStatus());
    }
}