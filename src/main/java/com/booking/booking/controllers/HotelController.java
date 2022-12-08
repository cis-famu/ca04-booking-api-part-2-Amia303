package com.booking.booking.controllers;

import com.booking.booking.models.parse.Hotel;
import com.booking.booking.models.serializable.SerializableHotel;
import com.booking.booking.models.parse.Hotel;
import com.booking.booking.services.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController //identified this class a controller used for REST API class.
@RequestMapping("/api/v1/hotel") //sets up the base url for all calls to methods in this file

public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    //get all
    @GetMapping("/") //sets the path to this method
    public ArrayList<SerializableHotel> getHotel(@RequestParam(name = "sort" , required = false, defaultValue = "asc") String sort) {
        ArrayList<SerializableHotel> Hotel = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<Hotel> list = hotelService.retrieveHotels(sort);
        for(Hotel p : list)
        {
            Hotel.add(p.getSerializable());
        }
        return Hotel;
    }

    //get only one based on object id
    @GetMapping("/find/{id}")
    public SerializableHotel getHotelById(@PathVariable String id){
        return hotelService.getHotelById(id).getSerializable();
    }

    @PostMapping("/")
    public String creatHotel(@RequestBody SerializableHotel hotel){
        return hotelService.addHotel(hotel);
    }

    @PutMapping("/{id}")
    public String updateHotel(@PathVariable String id, @RequestBody Map<String, Object> hotel)
    {
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable String id)
    {
        return hotelService.removeHotel(id);
    }
}