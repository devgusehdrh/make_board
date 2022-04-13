package com.sparta.week1assign.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private Long post_id;
    private String post_subject;
    private String post_username;
    private String post_contents;
}
