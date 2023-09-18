package com.green.food_roulette.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentMonthListVo {

    private Long ipayment;
    private String paymentAt;
    private int total;
    private int cmt;
}
