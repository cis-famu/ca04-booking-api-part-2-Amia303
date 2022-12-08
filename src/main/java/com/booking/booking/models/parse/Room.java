package com.booking.booking.models.parse;

import com.booking.booking.models.RoomNumber;
import com.booking.booking.models.serializable.SerializableRoom;
import org.json.JSONArray;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

import java.util.ArrayList;

@ParseClassName("Room")
public class Room extends ParseObject {
    private final String ID = "id";
    private final String TITLE = "title";
    private final String PRICE = "price";
    private final String MAX = "maxPeople";
    private final String NUM = "roomNumbers";

    public String getId(){
        return getString(ID);
    }
    public void setId(String id){
        put(ID, id);
    }

    public String getTitle(){
        return getString(TITLE);
    }
    public void setTitle(String title){
        put(TITLE, title);
    }

    public double getPrice(){
        return getDouble(PRICE);
    }
    public void setPrice(double price){
        put(PRICE, price);
    }

    public int getMaxPeople(){
        return getInt(MAX);
    }
    public void setMaxPeople(int maxPeople){
        put(MAX, maxPeople);
    }

    public ArrayList<RoomNumber> getRoomNumbers(){
        return (ArrayList<RoomNumber>) get(NUM);
    }
    public void setRoomNumbers(ArrayList<RoomNumber> roomNumbers){
        put(NUM, createJSONArray(roomNumbers));
    }

    private JSONArray createJSONArray(ArrayList<?> arr )
    {
        JSONArray list = new JSONArray();
        for(Object s : arr)
            list.put(s);

        return list;
    }

    public SerializableRoom getSerializable(){
        return new SerializableRoom(
                getId(), getTitle(), getPrice(),
                getMaxPeople(), getRoomNumbers()
        );
    }
}