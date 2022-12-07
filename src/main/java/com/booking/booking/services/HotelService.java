package com.booking.booking.services;

import com.booking.booking.models.parse.Hotel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}