package com.green.food_roulette.user_menu.model;

import lombok.Data;

import java.util.List;

@Data
public class UserMenuInsDto {
    private Long iuser;
    private String menu;
    private List<String> tags;
}
