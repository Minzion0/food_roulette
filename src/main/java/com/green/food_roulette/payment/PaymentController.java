package com.green.food_roulette.payment;

import com.green.food_roulette.management.model.ManagementMonthVo;
import com.green.food_roulette.payment.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "유저 소비내역")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @PostMapping("/main")
    @Operation(summary = "당첨 메뉴 등록", description = "imenu=메뉴의 id값" +
            " imanagement=이달의 목표 id값" +
            "null이 리턴하면 등록 오류")
    public UserPaymentResVo setUserPayment(@RequestBody PyamentInsDto dto) throws Exception {
            return service.insUserPayment(dto);
    }

    @GetMapping("/calendar/{iuser}")
    @Operation(summary = "해당 달의 소비 내역들", description = "iuser=유저id" +
            "year = yy" +
            "month= mm")
    public List<PaymentMonthListVo> getUserPaymentList(@PathVariable Long iuser, String year, int month) {
        PaymentMonthListDto dto = new PaymentMonthListDto();
        dto.setIuser(iuser);
        dto.setYear(year);
        dto.setMonth(month);
        return service.getUserPaymentList(dto);
    }


    @GetMapping("/calendar/{iuser}/detail")
    @Operation(summary = "해당 일의 소비 내역들 ", description = "paymentAt ex)yy-mm-dd 날자정보" +
            "iuser= 유저 id")
    public List<PaymentDetailVo> getUserDetailPayment(@PathVariable Long iuser, String paymentAt) {
        PaymentDetailDto dto = new PaymentDetailDto();
        dto.setIuser(iuser);
        dto.setPaymentAt(paymentAt);
        return service.getUserDetailPayment(dto);

    }

    @GetMapping("/review/{iuser}")
    @Operation(summary = "리뷰 미등록 리스트")
    public List<PaymentReviewListVo>getNotReviewAt(@PathVariable Long iuser, String year, int month){
        PaymentMonthListDto dto = new PaymentMonthListDto();
        dto.setIuser(iuser);
        dto.setYear(year);
        dto.setMonth(month);
        return service.getNotReviewAt(dto);
    }

    @PatchMapping("/review/{iuser}")
    @Operation(summary = "후기 작성", description = "유저 id\n" +
            "  ipayment=리뷰 id값<br>" +
            " currentmenupirce= 먹은 가격<br>" +
            "review= 페페 스코어 1~3으로만 받기 가능<br>" +
            " restaurant =먹은 장소<br>" +
            " 리턴으로 1이 오면 정상 등록 -1이면 한도초과")
    public int reviewPayment(@PathVariable Long iuser, @RequestBody PaymentReviewDto dto) {

        try {
            return service.reviewPayment(dto, iuser);
        } catch (Exception e) {
            return -1;
        }

    }

    @DeleteMapping("/calendar/{iuser}/detail")
    @Operation(summary = "소비내역 삭제",description = "ipayment= 소비내역 id 번호 " +
            "imanagement = 삭제할 대상의 imanagement id")
    public ManagementMonthVo deldteUserPayment(@PathVariable Long iuser, @RequestParam Long ipayment,@RequestParam Long imanagement){
        PaymentDelDto dto = new PaymentDelDto();
        dto.setIpayment(ipayment);
        dto.setIuser(iuser);
        dto.setImanagement(imanagement);
        try {
            return service.deldteUserPayment(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
