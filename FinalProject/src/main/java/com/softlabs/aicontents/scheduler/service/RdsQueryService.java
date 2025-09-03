//package com.softlabs.aicontents.scheduler.service;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Component
//@Service
//@RequiredArgsConstructor
//@Slf4j
//
//public class RdsQueryService {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    //RDS 연결 상태 확인
//    public String checkRdsStatus() {
//        try {
//            String result = jdbcTemplate.queryForObject(
//                    "SELECT 'RDS 연결 정상!' FROM dual",
//                    String.class
//            );
//            log.info("RDS 상태 확인 성공:{}", result);
//            return result;
//        } catch (Exception e) {
//            log.error("RDS 연결 실패", e);
//            return "RDS 연결 실패: " + e.getMessage();
//        }
//    }
//
//
//    //현재 시간 조회(RDS 서버 시간)
//    public String getCurrentTime() {
//        try {
//            return jdbcTemplate.queryForObject(
//                    "SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM dual",
//                    String.class
//            );
//        } catch (Exception e) {
//            return "시간 조회 실패 : " + e.getMessage();
//        }
//    }
//
//    // 기존 테이블 목록 조회
//
//    public List<? extends Object> getExistingTables() {
//        try {
//            return jdbcTemplate.queryForList(
//                    "SELECT code_group, code_value, code_name FROM COMMON_CODES"
//
//            );
//        } catch (Exception e) {
//            log.error("테이블 목록 조회 실패", e);
//            return List.of("조회 실패: " + e.getMessage());
//        }
//    }
//
//
//}
