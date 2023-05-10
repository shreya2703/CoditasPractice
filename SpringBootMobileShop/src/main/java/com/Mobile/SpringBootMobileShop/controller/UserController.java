package com.Mobile.SpringBootMobileShop.controller;

import com.Mobile.SpringBootMobileShop.model.Login;
import com.Mobile.SpringBootMobileShop.model.User;
import com.Mobile.SpringBootMobileShop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mobileshop")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }


//    @PostMapping("/login")
//    public ResponseEntity<Login> loginUser(@RequestBody Login login){
//
//
//    }

}
