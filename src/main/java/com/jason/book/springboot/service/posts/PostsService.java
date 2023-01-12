package com.jason.book.springboot.service.posts;

import com.jason.book.springboot.domain.posts.PostsRepositoty;
import com.jason.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepositoty postsRepositoty;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepositoty.save(requestDto.toEntity()).getId();
    }
}
