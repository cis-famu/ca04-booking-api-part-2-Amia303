package com.booking.booking.models.serializable;

import com.booking.booking.models.RoomNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerializableRoom {
    private String id;
    private String title;
    private double price;
    private int maxPeople;
    private ArrayList<RoomNumber> roomNumbers;
}