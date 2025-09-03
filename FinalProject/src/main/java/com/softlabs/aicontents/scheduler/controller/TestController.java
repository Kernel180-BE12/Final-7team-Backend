//package com.softlabs.aicontents.scheduler.controller;
//
//
//import com.softlabs.aicontents.scheduler.service.TestService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
////q. @RestController의 기능과 의미?
//
//@RequestMapping("/task")
//@RequiredArgsConstructor
////q. 이 어노테이션의 기능은? / 순서가 중요한가?
//public class TestController {
//
//        private final TestController testController;
//    private final TestService testService;
//
//    //INSERT 테스트
//    @GetMapping("/insert")
//    public String insertTask(){
//        return testService.insertTask("테스트작업", "0 0 8 * * ?", "매일 8시 실행");
//    }
//    // 개수 확인
//    @GetMapping("/count")
//    public String getCount() {
//        return testService.getTasks();
//    }
//
//}
//
//
