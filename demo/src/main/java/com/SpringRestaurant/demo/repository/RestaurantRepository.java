package com.SpringRestaurant.demo.repository;

import com.SpringRestaurant.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

}
