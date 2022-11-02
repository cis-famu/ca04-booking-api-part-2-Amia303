package com.booking.booking.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;

@Service //lets Spring know that this is a service
public class HotelService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<Product> retrieveProducts()
    {

        logger.info(Parse.isIsRootMode());
        final ArrayList<Product> products = new ArrayList<>();

        ParseQuery<Product> query = ParseQuery.getQuery(Product.class);
        try {
            List<Product> list = query.find();
            for (Product p : list) {
                //logger.info(p.toString()); //use if you want to see your products in the console
                products.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(products.size());
        return products;
    }

    public Product getProductById(String id)
    {
        Product product = null;

        //defines the query for the product class
        ParseQuery<Product> query = ParseQuery.getQuery(Product.class);

        try{
            product = query.get(id); //gets a single record based on objectId
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return product;
    }
}
