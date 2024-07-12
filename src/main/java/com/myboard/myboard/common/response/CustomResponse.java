package com.myboard.myboard.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true) // final 필드가 선언된 경우 컴파일 타임에 기본값을 0 / null / false 로 설정
public class CustomResponse<T> {
    private final int status;
    private final String message;
    @Setter private T data;
}
