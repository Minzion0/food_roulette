package com.green.food_roulette.user_menu;

import com.green.food_roulette.user_menu.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMenuMapper {
    Long insUserMenu(UserMenuEntity entity);
    UserMenuFindVo findUserMenu(UserMenuEntity entity);
    UserMenuVo selUserMenu(Long iuserMenu);
    List<UserMenuRes> getUserMenu(UserMenuIuserDto dto);

    List<UserMenuVo> getActivationUserMenu(UserMenuIuserDto dto);
    int updActivation(UserMenuEntity entity);

    int findActivation(UserMenuEntity entity);
    List<MenusVo>  getMenus(UserMenuIuserDto dto);
    List<UserMenuRes> getMenusTest(UserMenuIuserDto dto);
}
