package com.booking.booking.models.parse;

public class Hotel { private final String TITLE = "title";
    private final String DESC = "desc";
    private final String IMG = "img";
    private final String CAT = "categories";
    private final String COLOR = "color";
    private final String SIZE = "size";
    private final String PRICE = "price";
    private final String INSTOCK = "inStock";

    public String getTitle() {
        return getString(TITLE);
    }

    public void setTitle(String title) {
        put(TITLE ,title);
    }

    public String getDesc() {
        return getString(DESC);
    }

    public void setDesc(String desc) {
        put(DESC, desc);
    }

    public String getImg() {
        return getString(IMG);
    }

    public void setImg(String img) {
        put(IMG, img);
    }

    public ArrayList<String> getCategories() {

        return (ArrayList<String>) get(CAT);
    }

    public void setCategories(ArrayList<String> categories) {
        put(CAT, createJSONArray(categories));
    }

    public ArrayList<String> getColor() {

        return (ArrayList<String>) get(COLOR);
    }

    public void setColor(ArrayList<String> color) {
        put(COLOR, createJSONArray(color));
    }

    public ArrayList<String> getSize() {

        return (ArrayList<String>) get(SIZE);
    }

    public void setSize(ArrayList<String> size) {
        put(SIZE, createJSONArray(size));
    }

    public double getPrice() {
        return getDouble(PRICE);
    }

    public void setPrice(double price) {
        put(PRICE, price);
    }

    public boolean getInStock() {
        return getBoolean(INSTOCK);
    }

    public void setInStock(boolean inStock) {
        put(INSTOCK, inStock);
    }


    private JSONArray createJSONArray(ArrayList<?> arr )
    {
        JSONArray list = new JSONArray();
        for(Object s : arr)
            list.put(s);

        return list;
    }

    public SerializableProduct getSerializable()
    {
        return new SerializableProduct(
                getObjectId(), getTitle(),getDesc(), getImg(),
                getCategories(),getColor(), getSize(), getPrice(),
                getInStock()
        );
    }
}
