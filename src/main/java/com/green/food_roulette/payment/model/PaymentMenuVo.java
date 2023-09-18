package com.green.food_roulette.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentMenuVo {
    private Long imanagement;
    private Long ipayment;
    private String menu;
    private String paymentAt;
}
