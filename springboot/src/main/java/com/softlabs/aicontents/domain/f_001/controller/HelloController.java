package com.softlabs.aicontents.domain.f_001.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스가 REST API 컨트롤러임을 나타냅니다.
public class HelloController {

        @GetMapping("/hello") // HTTP GET 요청이 "/hello" 경로로 오면 이 메소드를 실행합니다.
        public String hello() {
            return "안녕하세요! 프로젝트가 성공적으로 시작되었습니다!";
        }

    @GetMapping("/swagger-test")
    @Operation(summary = "Swagger 테스트 API", description = "Swagger UI에서 동작을 확인하기 위한 테스트용 API입니다.")
    public String swaggerTest() {
        return "Swagger 연동이 정상적으로 작동 중입니다!";
    }

    }


