package com.jason.book.springboot.web.dto;

import com.jason.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // assertj.core.api.Assertions.assertThat
        // Junit 의 assertThat을 쓰게 되면 is()와 같은 coreMatchers 라이브러리가 추가적으로 필요함.
        // 자동완성 기능이 좀 더 확실히 지원됨
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
