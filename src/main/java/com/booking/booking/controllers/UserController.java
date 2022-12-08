package com.booking.booking.controllers;
import com.booking.booking.models.parse.User;
import com.booking.booking.models.serializable.SerializableUser;
import com.booking.booking.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController //identified this class a controller used for REST API class.
@RequestMapping("/api/v1/user") //sets up the base url for all calls to methods in this file

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //get all
    @GetMapping("/") //sets the path to this method
    public ArrayList<SerializableUser> getUser(@RequestParam(name = "sort" , required = false, defaultValue = "asc") String sort) {
        ArrayList<SerializableUser> User = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<User> list = userService.retrieveUsers(sort);
        for(User p : list)
        {
            User.add(p.getSerializable());
        }
        return User;
    }

    //get only one based on object id
    @GetMapping("/find/{id}")
    public SerializableUser getHotelById(@PathVariable String id){
        return userService.getUserById(id).getSerializable();
    }

    @PostMapping("/")
    public String createUser(@RequestBody SerializableUser user){
        return userService.addUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody Map<String, Object> user)
    {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id)
    {
        return userService.removeUser(id);
    }
}