package com.nhnacademy.gateway.dto.project;

import com.nhnacademy.gateway.enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetailDto {
    private long projectId;
    private String title;
    private ProjectStatus status;
}
