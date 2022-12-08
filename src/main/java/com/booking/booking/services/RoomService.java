package com.booking.booking.services;

import com.booking.booking.models.parse.Hotel;
import com.booking.booking.models.parse.Room;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<Room> retrieveRooms(String sort)
    {

        logger.info(Parse.isIsRootMode());
        final ArrayList<Room> rooms = new ArrayList<>();
        List<Room> list = null;
        ParseQuery<Room> query = ParseQuery.getQuery(Room.class);
        try {
            if(sort.equals("asc")){
                list = query.orderByAscending("price").find();
            }else{
                list = query.orderByDescending("price").find();
            }
            for (Room p : list) {
                rooms.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(rooms.size());
        return rooms;
    }

    public Room getRoomById(String id)
    {
        Room room = null;

        ParseQuery<Room> query = ParseQuery.getQuery(Room.class);

        try{
            room = query.get(id);
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return room;
    }
}