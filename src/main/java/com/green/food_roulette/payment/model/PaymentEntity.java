package com.green.food_roulette.payment.model;

import lombok.Data;

@Data
public class PaymentEntity {
    private Long ipayment;
    private Long imenu;
    private Long imanagement;
    private String paymentAt;
    private int currentMenuPrice;
    private short reviewGrade;
    private String restauant;
}
