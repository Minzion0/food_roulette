package com.green.food_roulette.payment.model;


import lombok.Data;

@Data
public class PaymentMonthListDto {
    private Long iuser;
    private String year;
    private int month;
}
