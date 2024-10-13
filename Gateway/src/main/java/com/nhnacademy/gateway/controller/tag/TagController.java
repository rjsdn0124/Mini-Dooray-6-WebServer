package com.nhnacademy.gateway.controller.tag;

import com.nhnacademy.gateway.dto.auth.SignOnRequestDto;
import com.nhnacademy.gateway.dto.tag.TagDto;
import com.nhnacademy.gateway.dto.tag.TagReqDto;
import com.nhnacademy.gateway.dto.user.UserDto;
import com.nhnacademy.gateway.service.tag.TagService;
import com.nhnacademy.gateway.utils.loginUtil.CookieUtil;
import com.nhnacademy.gateway.utils.loginUtil.CustomUserDetail;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping("/tags")
    public void createTag(@ModelAttribute TagReqDto tagReqDto, HttpServletRequest req, HttpServletResponse res, Authentication authentication) throws IOException {
        String id = ((CustomUserDetail) authentication.getPrincipal()).getUsername();

        tagService.createTag(req, tagReqDto, id);

        res.sendRedirect("/project/"+tagReqDto.getProjectId());
    }

    @PutMapping("/tags/{id}")
    public void updateTag(@ModelAttribute TagReqDto tagReqDto, HttpServletRequest req, HttpServletResponse res, Authentication authentication) throws IOException {
        String id = ((CustomUserDetail) authentication.getPrincipal()).getUsername();

        tagService.updateTag(req, tagReqDto, id);

        res.sendRedirect("/projects/"+tagReqDto.getProjectId());
    }

    @DeleteMapping("/tags/{id}")
    public void deleteTag(HttpServletRequest req, HttpServletResponse res, Authentication authentication) throws IOException {
        String id = ((CustomUserDetail) authentication.getPrincipal()).getUsername();
        tagService.deleteTag(req, id);

        res.sendRedirect("/");
    }
}
