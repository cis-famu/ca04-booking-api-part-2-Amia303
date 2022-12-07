package com.booking.booking;

import com.booking.booking.models.parse.Hotel;
import com.booking.booking.models.parse.Room;
import com.booking.booking.models.parse.User;
import io.github.cdimascio.dotenv.Dotenv;
import org.parse4j.Parse;
import org.parse4j.util.ParseRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().filename("env").load();

        ParseRegistry.registerSubclass(Hotel.class);
        ParseRegistry.registerSubclass(Room.class);
        ParseRegistry.registerSubclass(User.class);

        Parse.initialize(dotenv.get("PARSE_APP_ID"), dotenv.get("PARSE_REST_ID"));
        SpringApplication.run(BookingApplication.class, args);
    }

}
