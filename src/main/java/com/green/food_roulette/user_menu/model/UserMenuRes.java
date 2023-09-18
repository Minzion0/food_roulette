package com.green.food_roulette.user_menu.model;

import lombok.Data;

import java.util.List;

@Data
public class UserMenuRes {
    private Long iuserMenu;
    private String menu;
    private List<UserMenuResm> tags;


}
