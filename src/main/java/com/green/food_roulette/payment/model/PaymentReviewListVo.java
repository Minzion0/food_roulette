package com.green.food_roulette.payment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentReviewListVo {

    private Long ipayment;
    private String paymentAt;
    private String menu;
    private int cmt;
}
