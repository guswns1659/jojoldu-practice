package com.jojoldu.book.springboot.web.dto;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloRequestDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloRequestDto helloRequestDto = new HelloRequestDto(name, amount);

        //then
        assertThat(helloRequestDto.getName()).isEqualTo(name);
        assertThat(helloRequestDto.getAmount()).isEqualTo(1000);
    }
}
