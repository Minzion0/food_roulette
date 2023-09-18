package com.green.food_roulette.payment.model;

import lombok.Data;

@Data
public class PaymentCalDto {
    private Long iuser;
    private int month;
    private String year;
    private int currentMenuPrice;
}
