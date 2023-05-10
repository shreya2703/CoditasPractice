package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class JavaConfig {

    @Bean
    public Emp getemp(){
        Emp e = new Emp();
        return e;
    }
}
