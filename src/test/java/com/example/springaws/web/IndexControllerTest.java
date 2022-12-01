package com.example.springaws.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test//메인 페이지에 문자열이 잘 뜨는지 테스트
    public void mainPageLoading(){
        //when
        String body = this.restTemplate.getForObject("/",String.class);

        //then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
