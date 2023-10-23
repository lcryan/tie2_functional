package com.example.tie2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class CiModuleDto {
    private Long id;
    private String name;
    private String type;
    private Double price;
}
