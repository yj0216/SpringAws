package com.example.springaws.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter//모든 필드에 getter 자동생성
@RequiredArgsConstructor//선언된 모든 파이널 필드에 생성자 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
