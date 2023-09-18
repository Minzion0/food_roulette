package com.green.food_roulette.management.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ManagementRes {
    private ManagementMonthVo management;
    private List<ManagementPaymentVo> paymentVoList;
}
