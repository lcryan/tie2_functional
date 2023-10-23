package com.example.tie2.dtos;

import com.example.tie2.models.Authority;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    public String username;
    public String password;
    public String email;
    @JsonSerialize
    public Set<Authority> authoritySet;
}
