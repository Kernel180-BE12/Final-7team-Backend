package com.softlabs.aicontents.scheduler.dto.requestDTO;

public record ScheduleResponseDTO(
        Long taskId,
        String taskName,
        String cronExpression,
        String status
) {}