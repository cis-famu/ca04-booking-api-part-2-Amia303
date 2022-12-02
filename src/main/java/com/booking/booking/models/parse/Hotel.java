package com.booking.booking.models.parse;

import edu.famu.booking.models.serializable.SerializableHotel;
import org.json.JSONArray;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

import java.util.ArrayList;
@ParseClassName("Hotel")
public class Hotel extends ParseObject {
    private final String ID = "id";
    private final String NAME = "name";
    private final String TYPE = "type";
    private final String CITY = "city";
    private final String ADDRESS = "address";
    private final String DISTANCE = "distance";
    private final String PHOTOS = "photos";
    private final String TITLE = "title";
    private final String RATING = "rating";
    private final String ROOMS = "rooms";
    private final String CHEAPEST = "cheapestPrice";
    private final String FEATURED = "featured";

    public String getId(){
        return getString(ID);
    }
    public void setId(String id){
        put(ID, id);
    }

    public String getName(){
        return getString(NAME);
    }
    public void setName(String name){
        put(NAME, name);
    }

    public String getType(){
        return getString(TYPE);
    }
    public void setType(String type){
        put(TYPE, type);
    }

    public String getCity(){
        return getString(CITY);
    }
    public void setCity(String city){
        put(CITY, city);
    }

    public String getAddress(){
        return getString(ADDRESS);
    }
    public void setAddress(String address){
        put(ADDRESS, address);
    }

    public String getDistance(){
        return getString(DISTANCE);
    }
    public void setDistance(String distance){
        put(DISTANCE, distance);
    }

    public ArrayList<String> getPhotos(){
        return (ArrayList<String>) get(PHOTOS);
    }
    public void setPhotos(ArrayList<String> photos){
        put(PHOTOS, createJSONArray(photos));
    }

    public String getTitle(){
        return getString(TITLE);
    }
    public void setTitle(String title){
        put(TITLE, title);
    }

    public int getRating(){
        return getInt(RATING);
    }
    public void setRating(int rating){
        put(RATING, rating);
    }

    public ArrayList<Room> getRooms(){
        return (ArrayList<Room>) get(ROOMS);
    }
    public void setRooms(ArrayList<Room> rooms){
        put(ROOMS, createJSONArray(rooms));
    }

    public double getCheapestPrice(){
        return getInt(CHEAPEST);
    }
    public void setCheapestPrice(double cheapestPrice){
        put(CHEAPEST, cheapestPrice);
    }

    public boolean getFeatured(){
        return getBoolean(FEATURED);
    }
    public void setFeatured(boolean featured){
        put(FEATURED, featured);
    }

    public SerializableHotel getSerializable(){
        return new SerializableHotel(
                getId(), getName(), getType(), getCity(),
                getAddress(), getDistance(), getPhotos(), getTitle(),
                getRating(), getRooms(), getCheapestPrice(), getFeatured()
        );
    }

    private JSONArray createJSONArray(ArrayList<?> arr )
    {
        JSONArray list = new JSONArray();
        for(Object s : arr)
            list.put(s);

        return list;
    }
}
