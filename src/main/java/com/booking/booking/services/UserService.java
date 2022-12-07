package com.booking.booking.services;

import com.booking.booking.models.parse.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<User> retrieveUsers(String sort)
    {

        logger.info(Parse.isIsRootMode());
        final ArrayList<User> users = new ArrayList<>();
        List<User> list = null;
        ParseQuery<User> query = ParseQuery.getQuery(User.class);
        try {
            if(sort.equals("asc")){
                list = query.orderByAscending("username").find();
            }else{
                list = query.orderByDescending("username").find();
            }

            for (User p : list) {
                users.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(users.size());
        return users;
    }

    public User getUserById(String id)
    {
        User user = null;

        ParseQuery<User> query = ParseQuery.getQuery(User.class);

        try{
            user = query.get(id); //gets a single record based on objectId
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return user;
    }
}