package com.sparta.week1assign.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long post_id, PostRequestDto requestDto){
        Post post = postRepository.findById(post_id).orElseThrow(
                () -> new NullPointerException("해당하는 게시글이 존재하지 않습니다")
        );
        post.update(requestDto);
        return post.getPost_id();
    }
}
