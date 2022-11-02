package com.booking.booking.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    protected final Log logger = LogFactory.getLog(this.getClass());

    public ArrayList<Order> retrieveOrders()
    {
        final ArrayList<Order> orders = new ArrayList<>();

        ParseQuery<Order> query = ParseQuery.getQuery(Order.class);
        try {
            List<Order> list = query.find();
            for (Order o : list) {

                orders.add(o);
            }

        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }

        logger.info(orders.size());
        return orders;
    }
}
