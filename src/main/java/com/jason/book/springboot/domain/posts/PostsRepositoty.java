package com.jason.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 단순히 JpaRepository를 상속하면 기본적인 CRUD메소드가 자동으로 생성됨.
public interface PostsRepositoty extends JpaRepository<Posts,Long> {
}
