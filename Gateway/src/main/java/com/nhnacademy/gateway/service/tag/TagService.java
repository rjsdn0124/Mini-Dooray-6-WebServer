package com.nhnacademy.gateway.service.tag;

import com.nhnacademy.gateway.dto.auth.SignOnRequestDto;
import com.nhnacademy.gateway.dto.project.ProjectBreifDto;
import com.nhnacademy.gateway.dto.tag.TagDto;
import com.nhnacademy.gateway.dto.tag.TagReqDto;
import com.nhnacademy.gateway.enums.API;
import com.nhnacademy.gateway.utils.routeUtil.RestTemplateUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final RestTemplateUtil restTemplateUtil;

    public void createTag(HttpServletRequest req, TagReqDto tagReqDto, String userId){
        restTemplateUtil.getResponse(userId, API.TASK, req, tagReqDto, Void.class);
    }

    public List<TagDto> getTagList(long projectId, String userId){
        return restTemplateUtil.getResponse(userId, API.TASK, "/tags/projects/" + projectId, (Class<List<TagDto>>) (Class<?>) List.class).getBody();
    }

    public void deleteTag(HttpServletRequest req, String userId){
        restTemplateUtil.getResponse(userId, API.TASK, req, null, Void.class).getBody();
    }

    public void updateTag(HttpServletRequest req, TagReqDto tagReqDto, String userId){
        restTemplateUtil.getResponse(userId, API.TASK, req, tagReqDto, Void.class);
    }
}
