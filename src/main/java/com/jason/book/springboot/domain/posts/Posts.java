package com.jason.book.springboot.domain.posts;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity // @Entity 어노테이션은 JPA의 어노테이션이거 @NoArgsConstructor는 롬복의 어노테이션이다. 롬복 어노테이션은 필수 어노테이션이 아니므로 JPA어노테이션을 클래스와 가깝게 두고 롬복어노테이션을 그 위에 둠. 후에 코틀린같은 새언어로 전환할시에 롬복어노테이션들을 쉽게 삭제가능하다. / 테이블과 링크될 클래스임 / 기본값으로 카멜케이스를 언더스코어 네이밍으로 테이블명으로 매칭함
public class Posts {

    @Id //PK
    @GeneratedValue //PK의 생성 규칙을 나타냄
    private Long id;

    @Column(length = 500, nullable = false) // 굳이 선언하지 않더라도 기본값으로 클래스의 필드들은 모두 칼럼이 됨 / 기본값이외에 추가 변경이 있을경우 사용함
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
