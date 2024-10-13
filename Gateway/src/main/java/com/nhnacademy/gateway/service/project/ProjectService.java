package com.nhnacademy.gateway.service.project;

import com.nhnacademy.gateway.dto.project.ProjMemReqDto;
import com.nhnacademy.gateway.dto.project.ProjectBreifDto;
import com.nhnacademy.gateway.dto.project.ProjectDetailDto;
import com.nhnacademy.gateway.dto.project.ProjectReqDto;
import com.nhnacademy.gateway.enums.API;
import com.nhnacademy.gateway.utils.routeUtil.RestTemplateUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final RestTemplateUtil restTemplateUtil;

    public ProjectDetailDto getProject(HttpServletRequest req, String userId){
        return restTemplateUtil.getResponse(userId, API.TASK, req.getRequestURI(), ProjectDetailDto.class).getBody();
    }

    public ProjectDetailDto createProject(HttpServletRequest req, ProjectReqDto projectReqDto, String userId){
        return restTemplateUtil.getResponse(userId, API.TASK, req, projectReqDto, ProjectDetailDto.class).getBody();
    }

    public List<ProjectBreifDto> getProjAdminList(String userId){
        return restTemplateUtil.getResponse(userId, API.TASK, "/projects/user", (Class<List<ProjectBreifDto>>) (Class<?>) List.class).getBody();
    }

    public List<ProjectBreifDto> getProjMemList(String userId){
        return restTemplateUtil.getResponse(userId, API.TASK, "/users/"+userId+"/projects", (Class<List<ProjectBreifDto>>) (Class<?>) List.class).getBody();
    }

    public void addMemInProj(HttpServletRequest req, ProjMemReqDto projMemReqDto, String userId){
        restTemplateUtil.getResponse(userId, API.TASK, req, projMemReqDto, Void.class);
    }
}
