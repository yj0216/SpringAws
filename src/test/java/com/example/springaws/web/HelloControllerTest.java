package com.example.springaws.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringRunner.class)//junit5부터는 자동으로 설정되서 삭제됨
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired//스프링이 관리하는 빈을 주입 받음
    private MockMvc mvc;//스프링 테스트에 시작점

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)//API 테스트시 사용될 요청 파라미터 설정
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))//json 응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
