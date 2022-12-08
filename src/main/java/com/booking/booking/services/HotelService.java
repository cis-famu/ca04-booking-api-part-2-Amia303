package com.booking.booking.services;

import com.booking.booking.models.parse.Hotel;
import com.booking.booking.models.serializable.SerializableHotel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<Hotel> retrieveHotels(String sort)
    {

        logger.info(Parse.isIsRootMode());
        final ArrayList<Hotel> hotels = new ArrayList<>();
        List<Hotel> list = null;

        ParseQuery<Hotel> query = ParseQuery.getQuery(Hotel.class);

        try {

            if(sort.equals("asc")){
                list = query.orderByAscending("cheapestPrice").find();
            }else{
                list = query.orderByDescending("cheapestPrice").find();
            }

            for (Hotel p : list) {
                hotels.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(hotels.size());
        return hotels;
    }

    public Hotel getHotelById(String id)
    {
        Hotel hotel = null;

        ParseQuery<Hotel> query = ParseQuery.getQuery(Hotel.class);

        try{
            hotel = query.get(id);
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return hotel;
    }

    public String addHotel(SerializableHotel hotel)
    {
        String message;

        Hotel parseHotel = new Hotel(); //Parse Hotel Object

        //set the value of each of the fields
        parseHotel.setName(hotel.getName());
        parseHotel.setType(hotel.getType());
        parseHotel.setCity(hotel.getCity());
        parseHotel.setAddress(hotel.getAddress());
        parseHotel.setDistance(hotel.getDistance());
        parseHotel.setPhotos(hotel.getPhotos());
        parseHotel.setTitle(hotel.getTitle());
        parseHotel.setRating(hotel.getRating());
        parseHotel.setRooms(hotel.getRooms());
        parseHotel.setCheapestPrice(hotel.getCheapestPrice());
        parseHotel.setFeatured(hotel.isFeatured());

        try {
            parseHotel.save(); //runs the query to insert the new value
            message = "Hotel Created"; //set success the return message
        } catch (ParseException e) {
            e.printStackTrace(); //print the error to the console
            //set the error return message
            message = "Error creating hotel. " + e.getMessage();
        }

        return message;
    }

    public String updateHotel(String id, Map<String, Object> hotel)
    {
        String message;

        String[] strList = {"name", "type", "city", "address", "distance", "title"};
        String[] arrList = {"photos", "rooms"};

        ParseQuery<Hotel> query = ParseQuery.getQuery(Hotel.class);

        try {
            Hotel hotel1 = query.get(id);
            hotel.forEach((k,v) -> {
                if(Objects.equals(k, "rating"))
                    hotel1.put(k, (Integer)v);
                else if(Objects.equals(k, "cheapestPrice"))
                    hotel1.put(k, (Double)v);
                else if(Objects.equals(k, "featured"))
                    hotel1.put(k, (Boolean)v);
                else if(Arrays.asList(strList).contains(k))
                    hotel1.put(k, (String)v);
                else if(Arrays.asList(arrList).contains(k))
                    hotel1.put(k, Arrays.asList(v));
            });
            hotel1.save(); //execute update query
            message = "Product updated."; //success message
        } catch (ParseException e) {
            e.printStackTrace();
            message = "Error updating product. " + e.getMessage(); //failure message
        }

        return message;
    }

    public String removeHotel(String id)
    {
        String message;

        //defines the query for the hotel class
        ParseQuery<Hotel> query = ParseQuery.getQuery(Hotel.class);

        try
        {
            Hotel hotel = query.get(id); //get product by id
            hotel.delete(); //delete product
            message = "Hotel " + id + " deleted."; //success message
        } catch (ParseException e){
            e.printStackTrace();
            message = "Error while deleting hotel. " + e.getMessage(); //error message
        }

        return message;
    }
}