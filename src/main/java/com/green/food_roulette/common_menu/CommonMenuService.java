package com.green.food_roulette.common_menu;


import com.green.food_roulette.common_menu.model.CommonMenuVo;
import com.green.food_roulette.user_menu.model.MenusVo;
import com.green.food_roulette.user_menu.model.UserMenuRes;
import com.green.food_roulette.user_menu.model.UserMenuResm;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonMenuService {

    private final CommonMenuMapper mapper;

    public  List<UserMenuRes> getCommonMenu(){
        List<MenusVo> menus= mapper.getCommonMenu();

        return getUserMenuRes(menus);
    }
    private  List<UserMenuRes> getUserMenuRes(List<MenusVo> menus) {
        List<UserMenuRes> userMenuList =new ArrayList<>();
        UserMenuRes userMenuRes;
        UserMenuResm userMenuResm;
        List<UserMenuResm> tagList;
        for (int i = 0; i < menus.size(); i++) {
            userMenuRes = new UserMenuRes();
            userMenuRes.setIuserMenu(menus.get(i).getIusermenu());
            userMenuRes.setMenu(menus.get(i).getMenu());

            String tags = menus.get(i).getTags();
            String itags = menus.get(i).getItags();
            String[] tagSplit = tags.split(",");
            String[] itagSplit = itags.split(",");


            tagList = new ArrayList<>();
            for (int j = 0; j < tagSplit.length; j++) {
                userMenuResm = new UserMenuResm();
                userMenuResm.setTag(tagSplit[j]);
                userMenuResm.setItag(Long.valueOf(itagSplit[j]));
                tagList.add(userMenuResm);
            }
            userMenuRes.setTags(tagList);
            userMenuList.add(userMenuRes);

        }
        return userMenuList;
    }
}
