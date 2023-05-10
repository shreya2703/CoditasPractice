package com.springBoot.springexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {
    //get
    //post
    //put
    //delete
    @GetMapping("/")
    public String helloWorld(){
        return "HelloWorld!!";
    }





}
