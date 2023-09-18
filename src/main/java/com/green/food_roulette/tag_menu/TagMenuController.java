package com.green.food_roulette.tag_menu;

import com.green.food_roulette.tag_menu.model.TagMenuGetDto;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagDto;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagVo;
import com.green.food_roulette.tag_menu.model.TagMenuInsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "태그")
@RestController
@RequestMapping("/api")
public class TagMenuController {
    private final TagMenuService service;

    @PostMapping("/menu/{iuser}/tag")
    @Operation(summary = "태그 한개 생성",description = "imenu 값을 받아 태그를 만듬 -1이 오면 메뉴에 있는 태그")
    public Long insTag(@RequestBody TagMenuInsDto dto){
        return service.insTag(dto);

    }

//    @GetMapping("/main/{iuser}/menu")
    @PostMapping("/main/{iuser}/menu")
    @Operation(summary = "태그로 메뉴 검색",description = "list는 태그를 String타입배열로 받는다 ")
    public List<TagMenuGetTagVo> getTagMenu(@RequestBody TagMenuGetDto dto, @PathVariable Long iuser){
        return service.getTagMenu(dto,iuser);
    }

}
