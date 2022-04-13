package com.sparta.week1assign.domain;

import lombok.Getter;


@Getter
public class ReplyRequestDto {
    private Long comment_id;
    private Long postid;
    private String comment_username;
    private String comment_contents;
}
