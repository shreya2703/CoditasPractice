package com.Mobile.SpringBootMobileShop.repository;

import com.Mobile.SpringBootMobileShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
