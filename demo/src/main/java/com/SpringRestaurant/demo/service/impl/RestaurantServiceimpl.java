package com.SpringRestaurant.demo.service.impl;

import com.SpringRestaurant.demo.model.Restaurant;
import com.SpringRestaurant.demo.repository.RestaurantRepository;
import com.SpringRestaurant.demo.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceimpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantServiceimpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
//    @Override
//    public Restaurant saveRestaurant(Restaurant restaurant) {
//        return restaurantRepository.save(restaurant);
//    }
}
