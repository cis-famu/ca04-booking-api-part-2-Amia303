package com.booking.booking.services;

public class UserService {
    protected final Log logger = LogFactory.getLog(this.getClass());

    public ArrayList<Cart> retrieveCarts()
    {
        final ArrayList<Cart> carts = new ArrayList<>();

        ParseQuery<Cart> query = ParseQuery.getQuery(Cart.class);
        try {
            List<Cart> list = query.find();
            for (Cart c : list) {
                carts.add(c);
            }

        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }

        return users;
    }
}