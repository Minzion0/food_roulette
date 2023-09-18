package com.green.food_roulette.user;

import com.green.food_roulette.user.model.UserEntity;
import com.green.food_roulette.user.model.UserInsDto;
import com.green.food_roulette.user.model.UserIuserDto;
import com.green.food_roulette.user.model.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.zip.ZipException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    public UserVo postUser(UserInsDto dto){
        UserVo vo = new UserVo();
        vo.setName(dto.getName());
        mapper.insUser(vo);
        return vo;
    }
    public UserVo getUser(UserIuserDto dto){
        return mapper.getUser(dto);
    }
}
