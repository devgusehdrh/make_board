package com.sparta.week1assign.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Reply extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long comment_id;

    @Column
    private Long postid;

    @Column
    private String comment_username;

    @Column
    private String comment_contents;

    public Reply(String comment_username, String comment_contents, Long postid){
        this.comment_username = comment_username;
        this.comment_contents = comment_contents;
        this.postid = postid;
    }
    public Reply(ReplyRequestDto requestDto){
        this.comment_username = requestDto.getComment_username();
        this.comment_contents = requestDto.getComment_contents();
        this.postid = requestDto.getPostid();
    }
    public void update(ReplyRequestDto requestDto){
        this.comment_username = requestDto.getComment_username();
        this.comment_contents = requestDto.getComment_contents();
        this.postid = requestDto.getPostid();
    }
}