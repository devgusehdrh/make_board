package com.sparta.week1assign.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional
    public Long reply_update(Long comment_id, ReplyRequestDto requestDto){
        Reply reply = replyRepository.findById(comment_id).orElseThrow(
                () -> new NullPointerException("해당하는 댓글이 존재하지 않습니다")
        );
        reply.update(requestDto);
        return reply.getComment_id();
    }
}
