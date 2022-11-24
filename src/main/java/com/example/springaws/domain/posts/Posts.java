package com.example.springaws.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity//테이블과 링크된 클래스임을 나타냄
public class Posts {

    @Id//해당 태이블의 PK(Primary Key)필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK의 생성 규칙
    private Long id;

    @Column(length = 500,nullable = false)//기본값 외에 추가로 변경이 필요할시 사용
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
