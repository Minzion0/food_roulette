package com.green.food_roulette.user_menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserMenuVo {
    private Long iuserMenu;
    private String menu;
    private Long itag;
    private String tag;
}
