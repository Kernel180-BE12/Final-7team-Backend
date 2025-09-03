package com.softlabs.aicontents.scheduler.controller;


import com.softlabs.aicontents.scheduler.dto.requestDTO.ScheduleRequestDTO;
import com.softlabs.aicontents.scheduler.dto.requestDTO.ScheduleResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*")
public class SchedulerController {

    @GetMapping("/tasks")  //스케줄 목록을 조회

        public List<ScheduleResponseDTO> getScheduleResponseDTO() {
            return List.of(
                    new ScheduleResponseDTO(1L, "매일 실행", "0 0 8 * * ?", "활성"),
                    new ScheduleResponseDTO(2L, "주간 실행", "0 0 9 * * MON", "비활성")
            );
    }
    
    @PostMapping("/tasks") //새 스케줄 생성
    
            public ScheduleResponseDTO createScheduleResponseDTO(@RequestBody ScheduleRequestDTO dto) {
                return new ScheduleResponseDTO(
                        99L,
                        dto.taskName(),
                        dto.cronExpression(),
                        "생성됨"
                );
    }
}
