package com.SpringRestaurant.demo.controller;

import com.SpringRestaurant.demo.model.Restaurant;
import com.SpringRestaurant.demo.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
         private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
   @PostMapping
   public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant){
        return new ResponseEntity<Restaurant>(restaurantService.saveRestaurant(restaurant), HttpStatus.CREATED);
   }







}
