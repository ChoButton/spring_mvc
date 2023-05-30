package com.spring.mvc.controller;

import com.spring.mvc.controller01.Car;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void carTest(){
        Car car = new Car();
        car.setModelName("SM6");
        car.setPrice(36000000);
        car.setOwnerName("조승연");
    }
}
