package com.green.food_roulette.user;

import com.green.food_roulette.user.model.UserEntity;
import com.green.food_roulette.user.model.UserIuserDto;
import com.green.food_roulette.user.model.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
   Long insUser(UserVo vo);
   UserVo getUser(UserIuserDto dto);
}
