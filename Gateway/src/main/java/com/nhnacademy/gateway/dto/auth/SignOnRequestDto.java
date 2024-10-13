package com.nhnacademy.gateway.dto.auth;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@ToString
public class SignOnRequestDto {
    String id;
    String pwd;
    String email;

    public void encode(PasswordEncoder pe){
        this.pwd = pe.encode(pwd);
    }
}
