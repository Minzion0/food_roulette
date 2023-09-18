package com.green.food_roulette.payment;

import com.green.food_roulette.payment.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    int insUserPayment(UserPaymentResVo vos);
    PaymentMenuVo getUserPic(Long ipayment);
    List<PaymentMonthListVo>getUserPaymentList(PaymentMonthListDto dto);
    List<PaymentReviewListVo>getNotReviewAt(PaymentMonthListDto dto);
    List<PaymentDetailVo>getUserDetailPayment(PaymentDetailDto dto);
    int reviewPayment(PaymentReviewDto dto);
    int getCruuntMenuPrice(PaymentDelDto dto);
    PaymentGetMonthVo getThisMonthPaymet(PaymentCalDto calDto);
    int deldteUserPayment(PaymentDelDto dto);
}
