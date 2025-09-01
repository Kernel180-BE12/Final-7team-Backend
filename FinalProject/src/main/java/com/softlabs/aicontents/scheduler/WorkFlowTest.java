//package com.softlabs.aicontents.scheduler;
//
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//public class WorkFlowTest {
//
//    @Autowired
//    private TestScheduler scheduler;
//
//    @Test
//    void workFlowTest(){
//        //실제 비즈니스 플로우 1회 실행 테스트
//        // 스케줄러가 정말로 4단계 순차 실행하는지 확인
//
//        //Given : 시작 시간 기록
//        LocalDateTime before = LocalDateTime.now();
//
//        //When
//        scheduler.excuteWorkFlow();
//
//        //Then : 실행시간 체크(대략 20초 내외 예상)
//        LocalDateTime after = LocalDateTime.now();
//        long duration = Duration.between(before,after).toSeconds();
//
//        assertThat(duration).isBetween(15L,30L);
//        System.out.println("WorkFlowTest 완료 시간 :"+duration + "초");
//    }
//
//
//}
