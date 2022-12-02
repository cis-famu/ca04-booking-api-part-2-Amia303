package edu.famu.booking.controllers;
import edu.famu.booking.models.parse.User;
import edu.famu.booking.models.serializable.SerializableUser;
import edu.famu.booking.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
}
