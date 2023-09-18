package com.green.food_roulette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FoodRouletteApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodRouletteApplication.class, args);
    }

}
