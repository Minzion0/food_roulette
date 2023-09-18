package com.green.food_roulette.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentDetailVo {
    private Long imanagement;
    private Long ipayment;
    private String  menu;
    private String paymentAt;
    private int currentMenuPrice;
    private short reviewGrade;
    private String restaurant;
}
