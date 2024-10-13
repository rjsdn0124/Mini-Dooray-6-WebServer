package com.nhnacademy.gateway.service.user;

import com.nhnacademy.gateway.dto.auth.SignOnRequestDto;
import com.nhnacademy.gateway.dto.user.UserDto;
import com.nhnacademy.gateway.dto.user.UserTaskDto;
import com.nhnacademy.gateway.enums.API;
import com.nhnacademy.gateway.utils.routeUtil.RestTemplateUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RestTemplateUtil restTemplateUtil;
    private final PasswordEncoder passwordEncoder;

    public UserDto getUser(String id){
        ResponseEntity<UserDto> re = this.restTemplateUtil.getResponse(id, API.ACCOUNT, "/user/" + id, UserDto.class);

        return re.getBody();
    }

    public UserDto createUser(HttpServletRequest req, SignOnRequestDto signOnRequestDto){
        signOnRequestDto.encode(passwordEncoder);

        ResponseEntity<UserDto> reAcc = this.restTemplateUtil.getResponse(signOnRequestDto.getId(), API.ACCOUNT, req, signOnRequestDto, UserDto.class);

        UserTaskDto userTaskDto = new UserTaskDto();
        userTaskDto.setUserId(signOnRequestDto.getId());
        ResponseEntity<Void> reTask = this.restTemplateUtil.getResponse(signOnRequestDto.getId(), API.TASK, req, userTaskDto, Void.class);
        return reAcc.getBody();
    }

    public void updateUser(HttpServletRequest req, UserDto userDto){
        ResponseEntity<UserDto> re = this.restTemplateUtil.getResponse(userDto.getId(), API.ACCOUNT, req, userDto, UserDto.class);
    }

    public void deleteUser(HttpServletRequest req){
        ResponseEntity<Void> reAcc = this.restTemplateUtil.getResponse(null, API.ACCOUNT, req, null, Void.class);
        ResponseEntity<Void> reTask = this.restTemplateUtil.getResponse(null, API.ACCOUNT, req, null, Void.class);

    }
}
