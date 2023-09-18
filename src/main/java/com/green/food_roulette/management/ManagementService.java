package com.green.food_roulette.management;

import com.green.food_roulette.management.model.*;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ManagementService {
    private final ManagementMapper mapper;

    public ManagementMonthVo setUserThisMonthManagement(ManagementEntity entity) {

        mapper.setUserThisMonthManagement(entity);
        ManagementMonthVo management = mapper.getUserThisMonthManagement(entity);


        return management ;


    }

    public ManagementMonthVo getUserThisMonthManagement(ManagementEntity entity) throws Exception {
        try {
            return mapper.getUserThisMonthManagement(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public ManagementRes getUserManagementList(ManagementEntity entity) {
        ManagementMonthVo userManagementList = mapper.getUserManagementList(entity);
        List<ManagementPaymentVo> userMonthPaymentList = mapper.getUserMonthPaymentList(entity);
        ManagementRes build = ManagementRes.builder().paymentVoList(userMonthPaymentList).management(userManagementList).build();
        return build;
    }

    @Transactional(rollbackFor = Exception.class)
    public ManagementMonthVo updUserMonthManagement(ManagementEntity entity) throws Exception {
        int result = mapper.updUserMonthManagement(entity);
        if (result == 0) {
            throw new Exception();
        }

        return mapper.getUserThisMonthManagement(entity);
    }


}
