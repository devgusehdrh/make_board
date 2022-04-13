package com.sparta.week1assign.controller;

import com.sparta.week1assign.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;
    private final ReplyRepository replyRepository;

    @PostMapping("/api/posts")
    public Post creatPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")
    public List<Post> getPost(){
        return postRepository.findAllByOrderByCreatedAtDesc();
    }


    @RequestMapping("/api/posts/{post_id}")
    public ModelAndView detailPost(@PathVariable Long post_id) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("posts");
        Optional<Post> data = postRepository.findById(post_id);
        Optional<Reply> reply = replyRepository.findById(post_id);

        mav.addObject("post_id", data.get().getPost_id());
        mav.addObject("post_subject", data.get().getPost_subject());
        mav.addObject("post_username", data.get().getPost_username());
        mav.addObject("post_contents", data.get().getPost_contents());
        mav.addObject("createdAt", data.get().getCreatedAt());

        return mav;
    }

    @PutMapping("/api/posts/{post_id}")
    public Long updatePost(@PathVariable Long post_id, @RequestBody PostRequestDto requestDto){
        return postService.update(post_id,requestDto);
    }

    @DeleteMapping("/api/posts/{post_id}")
    public Long deletePost(@PathVariable Long post_id){
        postRepository.deleteById(post_id);
        return post_id;
    }
}
