package com.green.food_roulette.payment;

import com.green.food_roulette.management.ManagementMapper;
import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import com.green.food_roulette.management.model.ManagementRemDto;
import com.green.food_roulette.payment.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper mapper;
    private final ManagementMapper managementMapper;

    @Transactional(rollbackFor = Exception.class)
    public UserPaymentResVo insUserPayment(PyamentInsDto dto)throws Exception {
        UserPaymentResVo vo = new UserPaymentResVo();
        vo.setImenu(dto.getImenu());
        vo.setImanagement(dto.getImanagement());
         mapper.insUserPayment(vo);
       return vo;

    }

    public List<PaymentMonthListVo> getUserPaymentList(PaymentMonthListDto dto) {
        return mapper.getUserPaymentList(dto);
    }

    public List<PaymentReviewListVo>getNotReviewAt(PaymentMonthListDto dto){
        return mapper.getNotReviewAt(dto);
    }

    public List<PaymentDetailVo> getUserDetailPayment(PaymentDetailDto dto) {
        return mapper.getUserDetailPayment(dto);
    }



    @Transactional(rollbackFor = Exception.class)
    public int reviewPayment(PaymentReviewDto dto, Long iuser) throws Exception {
        PaymentCalDto calDto = new PaymentCalDto();
        calDto.setIuser(iuser);
        calDto.setYear(dto.getYear());
        calDto.setMonth(dto.getMonth());
        calDto.setCurrentMenuPrice(dto.getCurrentMenuPrice());
        PaymentGetMonthVo thisMonthPaymet = mapper.getThisMonthPaymet(calDto);

        int balance = thisMonthPaymet.getBalance();

        if (balance - dto.getCurrentMenuPrice() < 0) {

            throw new Exception();
        }
        mapper.reviewPayment(dto);
        return managementMapper.calculateManagement(calDto);


    }
    @Transactional(rollbackFor = Exception.class)
    public ManagementMonthVo deldteUserPayment(PaymentDelDto dto)throws Exception {
        int cruuntMenuPrice = mapper.getCruuntMenuPrice(dto);

        ManagementRemDto remDto = new ManagementRemDto();
        remDto.setImanagement(dto.getImanagement());
        remDto.setIuser(dto.getIuser());
        remDto.setCruuntMenuPrice(cruuntMenuPrice);

        int result = mapper.deldteUserPayment(dto);
        if (result==0) throw new Exception();
        managementMapper.remManagement(remDto);
        ManagementMonthVo management = managementMapper.getManagement(remDto);
        return management;
    }
}
