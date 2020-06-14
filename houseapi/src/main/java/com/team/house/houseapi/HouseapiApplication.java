package com.team.house.houseapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(value = "com.team.house.houseapi.mapper")
@ServletComponentScan("com.team.house.houseapi.filter")
public class HouseapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseapiApplication.class, args);
    }

}
