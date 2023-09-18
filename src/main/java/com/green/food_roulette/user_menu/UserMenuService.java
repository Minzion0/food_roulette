package com.green.food_roulette.user_menu;


import com.green.food_roulette.tag.TagMapper;
import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag_menu.TagMenuMapper;

import com.green.food_roulette.tag_menu.model.TagMenuEntity;
import com.green.food_roulette.user_menu.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserMenuService {
    private final UserMenuMapper mapper;
    private final TagMapper tagMapper;
    private final TagMenuMapper tagMenuMapper;

    @Transactional(rollbackFor = ZipException.class)
    public int postUserMenu(UserMenuInsDto dto) throws ZipException {
        UserMenuEntity entity = new UserMenuEntity();
        entity.setMenu(dto.getMenu());
        entity.setIuser(dto.getIuser());
        UserMenuFindVo userMenu = mapper.findUserMenu(entity);
        if (userMenu == null) {
            mapper.insUserMenu(entity);
        } else if (userMenu.getIuserMenu() != null && userMenu.getActivation() == 1) {
            entity.setActivation(0);
            entity.setIuserMenu(userMenu.getIuserMenu());
            mapper.updActivation(entity);

        } else if (userMenu.getIuserMenu() != null && userMenu.getActivation() == 0) {
            throw new ZipException();
        }
        List<TagMenuEntity> itags = new ArrayList<>();
        for (int i = 0; i < dto.getTags().size(); i++) {
            TagMenuEntity tagMenuEntity = new TagMenuEntity();
            TagEntity tagEntity = new TagEntity();
            tagMenuEntity.setImenu(entity.getIuserMenu());
            tagEntity.setTag(dto.getTags().get(i));
            Long itag = tagMapper.findTag(tagEntity);
            if (itag == null) {
                tagMapper.insTag(tagEntity);
                itag = tagEntity.getItag();
            }
            tagMenuEntity.setItag(itag);
            itags.add(tagMenuEntity);
        }
        return tagMenuMapper.joinTagMenu(itags);
    }


    public List<UserMenuRes> getUserMenu(UserMenuIuserDto dto) {


        return  mapper.getUserMenu(dto);

    }



    public List<UserMenuVo> getActivationUserMenu(UserMenuIuserDto dto) {
        return mapper.getActivationUserMenu(dto);
    }

    public int updActivation(UserMenuIuserMenuDto dto) {
        UserMenuEntity entity = new UserMenuEntity();
        entity.setIuserMenu(dto.getIuserMenu());
        int result = mapper.findActivation(entity);
        if (result != 0) {
            entity.setActivation(0);
        } else {
            entity.setActivation(1);
        }
        System.out.println(entity.getActivation());
        mapper.updActivation(entity);
        return entity.getActivation();
    }




    public Long delMenuTag(UserMenuEntity entity) {
        int result = mapper.findActivation(entity);
        if (result == 0) {
            entity.setActivation(1);
            mapper.updActivation(entity);
        }
        return tagMenuMapper.delMenuTag(entity);
    }
        public Long delTag (TagMenuEntity entity){
            return tagMenuMapper.delTag(entity);
        }

    public List<UserMenuRes> getMenus(UserMenuIuserDto dto) {
        long start = System.currentTimeMillis();
        List<MenusVo> result = mapper.getMenus(dto);
        List<UserMenuRes> userMenuRes = getUserMenuRes(result);
        long end = System.currentTimeMillis();

        log.info("resultMap : {}", (end - start));
        return userMenuRes;

    }
    public List<UserMenuRes> getMenusTest(UserMenuIuserDto dto){
        long start = System.currentTimeMillis();
        List<UserMenuRes>  menusTest = mapper.getMenusTest(dto);
        long end = System.currentTimeMillis();
        log.info("groupConcat : {}", (end - start));
        return menusTest;
    }
        private  List<UserMenuRes> getUserMenuRes(List<MenusVo> menus) {
       List<UserMenuRes> userMenuList= new ArrayList<>();
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
