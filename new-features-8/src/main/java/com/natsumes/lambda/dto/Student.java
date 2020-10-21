package com.natsumes.lambda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;

    private String sex;

    private int salary;

    private int age;

    private String star;
}
