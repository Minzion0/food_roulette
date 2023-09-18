package com.green.food_roulette.payment.model;

import lombok.Data;

@Data
public class UserPaymentResVo {
    private Long imenu;
    private Long imanagement;
    private Long ipayment;
    private String menu;
    private String paymentAt;
}
