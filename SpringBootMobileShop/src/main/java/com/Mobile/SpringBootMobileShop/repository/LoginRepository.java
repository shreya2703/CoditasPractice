package com.Mobile.SpringBootMobileShop.repository;

import com.Mobile.SpringBootMobileShop.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Integer> {

}
