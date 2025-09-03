package com.softlabs.aicontents.scheduler.service;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class TestService {

    private final JdbcTemplate jdbcTemplate;
        //Q . JdbcTemplate의 역할과 기능?

    // test_SCHEDULED_TASKS 에 insert
    // 시간 설정 등 insert

    public String insertTask(String taskName, String cronExpression, String description) {

        try {
            jdbcTemplate.update(
                    "INSERT INTO TEST_SCHEDULED_TASKS (task_name, cron_expression, task_description)" +
                            "VALUES (?,?,?)",
                    taskName, cronExpression, description
            );
            return "INSERT 성공";
        } catch (Exception e) {
            return "INSERT 실패: " + e.getMessage();
        }
    }

    // 데이터 조회
    public String getTasks() {
        try {
            Integer count = jdbcTemplate.queryForObject(
                    //Q. queryForObject가 뭐냐 ?
                    "SELECT COUNT(*) FROM TEST_SCHEDULED_TASKS",
                    //Q. 조회인데 COUNT??
                    Integer.class
                    //Q.    Integer.class 이건 뭔데?
            );
            return "등록된 작업 수: " + count;
        } catch (Exception e) {
            return "조회 실패: " + e.getMessage();
        }
    }
}

