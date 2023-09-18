package com.green.food_roulette.payment.model;

import lombok.Data;

@Data
public class PaymentReviewDto {
    private Long ipayment;
    private int month;
    private String year;
    private int currentMenuPrice;
    private int reviewGrade;
    private String restaurant;
}
