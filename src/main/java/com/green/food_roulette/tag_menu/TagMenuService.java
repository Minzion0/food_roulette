package com.green.food_roulette.tag_menu;


import com.green.food_roulette.tag.TagMapper;
import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag_menu.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagMenuService {
    private final TagMenuMapper mapper;
    private final TagMapper tagMapper;

    public List<TagMenuGetTagVo> getTagMenu(TagMenuGetDto dto, Long iuser) {
        List<TagEntity> arrayList = new ArrayList<>();
        if (dto.getTags().size() == 0) {
            return null;
        }

        for (String tag : dto.getTags()) {
            TagEntity entity = new TagEntity();
            entity.setTag(tag.replaceAll("\\s", ""));
            arrayList.add(entity);
        }
        TagMenuGetTagDto tDto = new TagMenuGetTagDto();
        tDto.setSize(arrayList.size());
        tDto.setIuser(iuser);
        return mapper.getTagMenu(arrayList, arrayList.size(), iuser);
    }
        public Long insTag(TagMenuInsDto dto) {
            TagMenuEntity entity = new TagMenuEntity();
            entity.setImenu(dto.getImenu());
            TagEntity tagEntity = new TagEntity();
            tagEntity.setTag(dto.getTag());
            Long result = tagMapper.findTag(tagEntity);
            if (result != null) {
                List<TagMenuItagVo> menuTag = mapper.findUserMenuTag(entity);
                for (TagMenuItagVo itags : menuTag) {
                    if (result == itags.getItag()) {
                        return -1L;
                    }
                }
                entity.setItag(result);
                try {
                    Long it = mapper.insOneTag(entity);
                    return it;
                }catch (Exception e){
                    return -1L;
                }
            } else {
                tagMapper.insTag(tagEntity);
                entity.setItag(tagEntity.getItag());
                return mapper.insOneTag(entity);
            }



    }
}
