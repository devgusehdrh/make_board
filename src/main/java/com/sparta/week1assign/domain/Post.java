package com.sparta.week1assign.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long post_id;

    @Column
    private String post_subject;

    @Column
    private String post_username;

    @Column
    private String post_contents;

    public Post(String post_subject,String post_username, String post_contents){
        this.post_subject = post_subject;
        this.post_username = post_username;
        this.post_contents = post_contents;
    }
    public Post(PostRequestDto requestDto){
        this.post_subject = requestDto.getPost_subject();
        this.post_username = requestDto.getPost_username();
        this.post_contents = requestDto.getPost_contents();
    }
    public void update(PostRequestDto requestDto){
        this.post_subject = requestDto.getPost_subject();
        this.post_username = requestDto.getPost_username();
        this.post_contents = requestDto.getPost_contents();
    }
}
