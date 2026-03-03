package com.beyond.eljstl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Student {
    private String name;
    private int age;
    private int math;
    private int eng;
}
