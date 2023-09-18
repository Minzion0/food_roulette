package com.green.food_roulette.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ManagementPaymentVo {
    private String menu;
    private int sum;
    private int count;
}
