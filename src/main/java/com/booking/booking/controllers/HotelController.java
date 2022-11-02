package com.booking.booking.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

public class HotelController {
    private ProductService productService;

    public HotelController(ProductService productService) {
        this.productService = productService;
    }

    //get all
    @GetMapping("/") //sets the path to this method
    public ArrayList<SerializableProduct> getProducts() {
        ArrayList<SerializableProduct> products = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<Product> list = productService.retrieveProducts();
        for(Product p : list)
        {
            products.add(p.getSerializable());
        }
        return products;
    }

    //get only one based on object id
    @GetMapping("/find/{id}")
    public SerializableProduct getProductById(@PathVariable String id){
        return productService.getProductById(id).getSerializable();
    }
}
