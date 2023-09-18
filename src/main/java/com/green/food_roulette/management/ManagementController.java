package com.green.food_roulette.management;

import com.green.food_roulette.management.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/api")
@RestController
@Tag(name = "월별 목표")
@RequiredArgsConstructor
public class ManagementController {
    private final ManagementService service;

    @PostMapping("/main/{iuser}/plan")
    @Operation(summary = "이달의 목표 설정하기",description = "iuser=유저 pk" +
            "   monthLimit= 원하는 한도"  )
    public ManagementMonthVo setUserMonthManagement(@PathVariable Long iuser,@RequestBody ManagemetSetMonthDto dto){
        ManagementEntity entity = new ManagementEntity();
        entity.setMonthLimit(dto.getMonthLimit());
        entity.setIuser(iuser);
        return service.setUserThisMonthManagement(entity);
    }

    @GetMapping("/main/{iuser}")
    @Operation(summary = "이달의 목표 불러오기",description = "iuser=url의 iuser값을 읽어 실행")
    public ManagementMonthVo getUserThisMonthManagement(@PathVariable Long iuser){
        ManagementEntity entity = new ManagementEntity();
        entity.setIuser(iuser);
       try {
           return   service.getUserThisMonthManagement(entity);
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }

    @GetMapping("/calculate/{iuser}")
    @Operation(summary = "선택한 달의 목표와 소비내역",description = "iuser=유저 id," +
            " year = yyyy로 입력" +
            " month = dd")
    public ManagementRes getUserManagementList(@PathVariable Long iuser, @RequestParam int month,@RequestParam String year){
        ManagementEntity entity = new ManagementEntity();
        entity.setIuser(iuser);
        entity.setMonth(month);
        entity.setYear(year);
        return service.getUserManagementList(entity);
    }

    @PatchMapping("/main/{iuser}")
    @Operation(summary = "이달의 한도 수정",description = "monthLimit = 추가할 한도 기존한도에서 + 할 금액")
    public ManagementMonthVo patchUserMonthManagement(@PathVariable Long iuser,@RequestBody ManagemetSetMonthDto dto)throws Exception{
        ManagementEntity entity = new ManagementEntity();
        entity.setMonthLimit(dto.getMonthLimit());
        entity.setIuser(iuser);
        return service.updUserMonthManagement(entity);
    }



}
