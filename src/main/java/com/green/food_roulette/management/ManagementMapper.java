package com.green.food_roulette.management;

import com.green.food_roulette.management.model.*;
import com.green.food_roulette.payment.model.PaymentCalDto;
import com.green.food_roulette.payment.model.PaymentMonthListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagementMapper {
    int setUserThisMonthManagement(ManagementEntity entity);
    ManagementMonthVo getUserThisMonthManagement(ManagementEntity entity);
    ManagementMonthVo getUserManagementList(ManagementEntity entity);
    List<ManagementPaymentVo> getUserMonthPaymentList(ManagementEntity entity);
    ManagementMonthVo getManagement(ManagementRemDto dto);
    int updUserMonthManagement(ManagementEntity entity);

    int calculateManagement(PaymentCalDto dto);
    int  remManagement(ManagementRemDto dto);

}
