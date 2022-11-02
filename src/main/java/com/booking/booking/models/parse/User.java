package com.booking.booking.models.parse;

public class User {  final static String PRODUCTS = "products";
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
    public SerializableCart getSerializable() {
        return new SerializableCart(getObjectId(), getProducts());
    }
}