package com.green.food_roulette.user;

import com.green.food_roulette.user.model.UserInsDto;
import com.green.food_roulette.user.model.UserIuserDto;
import com.green.food_roulette.user.model.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.ZipException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "유저")
public class UserController {
    private final UserService service;
    @PostMapping
    @Operation(summary ="유저생성" ,description = "name=유저 이름이나 닉네임 입력 없으면 가입하고 있으면 있는 user id 리턴")
    public UserVo postUser(@RequestBody UserInsDto dto){
        return service.postUser(dto);
    }
//    @GetMapping("/{iuser}")
//    @Operation(summary = "유저 불러오기")
//    public UserVo getUser(@PathVariable Long iuser){
//        UserIuserDto dto = new UserIuserDto();
//        dto.setIuser(iuser);
//        return service.getUser(dto);
//    }
}
