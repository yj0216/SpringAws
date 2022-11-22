package com.example.springaws.web.domain.posts;


import com.example.springaws.domain.posts.Posts;
import com.example.springaws.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach//단위 테스트가 끝날떄마다 실행
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSave(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()//posts 테이블에 insert,update 쿼리 실행
                .title(title)
                .content(content)
                .author("yeojun0216@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();//posts 테이블에 있는 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
