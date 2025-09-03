//package com.softlabs.aicontents;
//
//
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@TestPropertySource(properties ={
//        "spring.main.lazy-initialization=true"
//})
//
//public class FirstSchedulerTest {
//
//    @Test //junit에게 테스트 메서드임을 알려주는 어노테이션
//    void contextLoads(){
//        //Spring Boot 애플리케이션이 정상 로드 확인용
//        assertThat(true).isTrue();
//        //AssertJ 라이브러리 사용한 검증문
//        System.out.println("스프링 부트 테스트 성공");
//    }
//
//
//    @Test
//    void schedulerTest(){
//        String expectedMessage ="스케줄러 준비 완료";
//        String actualMessage = "스케줄러 준비 완료";
//
//        assertThat(expectedMessage).isEqualTo(actualMessage);
//        System.out.println("스케줄러 기본 테스트 통과");
//    }
//
//    @Test
//    void pipelineStepTest(){
//        //파이프 라인 구조 테스트 (개념 확인)
//        String[] pipelineSteps={
//                "TREND_COLLECT",
//                "PRODUCT_CRWAL",
//                "CONTENT_GENRATE",
//                "BLOG_UPLOAD"
//        };
//        //AssertJ 라이브러리 사용한 검증문
//        assertThat(pipelineSteps).hasSize(4);
//        //pipelineStep의 크기가 4인지 검증
//
//        assertThat(pipelineSteps[0]).isEqualTo("TREND_COLLECT");
//        //pipelineSteps의 첫번째가 TREND_COLLECT 인지 검증
//
//        System.out.println("파이프라인 4단계 구조 확인 완료!");
//    }
//
//
//
//}
