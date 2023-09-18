package com.green.food_roulette.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentGetMonthVo {
    private int monthLimit;
    private int balance;
}
