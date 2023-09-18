package com.green.food_roulette.user_menu.model;

import lombok.Data;

@Data
public class UserMenuEntity {
    private Long iuserMenu;
    private Long iuser;
    private String menu;
    private int activation;
    private String arr;
}