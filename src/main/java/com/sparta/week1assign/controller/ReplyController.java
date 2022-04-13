package com.sparta.week1assign.controller;

import com.sparta.week1assign.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final ReplyRepository replyRepository;
    private final ReplyService replyService;

    @PostMapping("/api/replys")
    public Reply creatReply(@RequestBody ReplyRequestDto requestDto){
        Reply reply = new Reply(requestDto);
        return replyRepository.save(reply);
    }

    @RequestMapping("/api/replys/{postid}")
    public List<Reply> getReply(@PathVariable Long postid){
        return replyRepository.findAllByPostid(postid);
    }

//    @RequestMapping("/api/replys/{post_id}")
//    public ModelAndView getReply(@PathVariable Long post_id) throws Exception{
//        ModelAndView mav = new ModelAndView();
//
//        Optional<Reply> data = replyRepository.findById(post_id);
//
//        mav.addObject("comment_subject", data.get().getComment_contents());
//        mav.addObject("createdAt", data.get().getCreatedAt());
//
//        return mav;
//    }

    @PutMapping("/api/replys/{id}")
    public Long updateReply(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto){
        return replyService.reply_update(id,requestDto);
    }

    @DeleteMapping("/api/replys/{post_id}")
    public Long deleteReply(@PathVariable Long post_id){
        replyRepository.deleteById(post_id);
        return post_id;
    }
}
