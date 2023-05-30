package com.spring.mvc.controller01;

import lombok.*;

// @Data 는 순환참조의 문제가 있어 대신 아래와 같이 따로따로 사용하는걸 권장
@Getter
@Setter
@ToString
@NoArgsConstructor // 디폴트 생성자
public class Car {
    private String modelName;
    private int price;
    private String ownerName;
}
