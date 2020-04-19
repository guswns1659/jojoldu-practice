package com.jojoldu.book.springboot.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojoldu.book.springboot.web.dto.UserLoginRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    private Logger logger = LoggerFactory.getLogger(LoginControllerTest.class);

    @Test
    public void 로그인_테스트() throws Exception {
        //given
        UserLoginRequestDto user = new UserLoginRequestDto("sunny", "1234");

        ObjectMapper mapper = new ObjectMapper();
        String jsonUser = mapper.writeValueAsString(user);
        logger.info("jsonUser : {}", jsonUser);

        mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUser))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("200")));
    }
}
