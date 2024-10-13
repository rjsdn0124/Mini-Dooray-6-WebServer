package com.nhnacademy.gateway.dto.tag;

import lombok.Data;

@Data
public class TagReqDto {
    private String content;
    private long projectId;
}
