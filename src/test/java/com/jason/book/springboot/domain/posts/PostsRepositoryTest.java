package com.jason.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepositoty postsRepositoty;

    @After // 단위 테스트가 끝날 때마다 수행되는 메소드를 지정함, 보통 배포 전 전체 테스트를 수행할 때 테스트간 데이터침범을 막기 위해 사용함, 여러 데이터가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행 시 테스트가 실패할 수 있음.
    public void cleanup() {
        postsRepositoty.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepositoty.save(Posts.builder()
                .title(title)
                .content(content)
                .author("tmdgus5611@gmail.com")
                .build());

        List<Posts> postsList = postsRepositoty.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
