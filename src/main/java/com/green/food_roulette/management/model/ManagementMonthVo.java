package com.green.food_roulette.management.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ManagementMonthVo {
    private Long imanagement;
    private String year;
    private int month;
    private int monthLimit;
    private int balance;
    private int expense;
}
