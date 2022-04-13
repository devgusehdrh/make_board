package com.sparta.week1assign.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReplyRepository extends JpaRepository<Reply,Long> {
    List<Reply> findAllByPostid(Long postid);
}
