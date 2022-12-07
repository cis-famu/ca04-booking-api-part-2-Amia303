package com.booking.booking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomNumber {
    private String id;
    private int number;
    private ArrayList<Date> unavailableDates;

}