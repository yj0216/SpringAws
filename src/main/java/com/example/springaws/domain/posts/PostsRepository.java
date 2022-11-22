package com.example.springaws.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


//Entity 클래스와 Entity 레포지토리는 함께 위치해야함
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
