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
    public Boolean enabled;
    public String apiKey;

    @JsonSerialize
    public Set<Authority> authoritySet;

    public Set<Authority> getAuthorities() {
        return authoritySet;
    }

    public void setAuthorities(Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    public void setApikey(String apiKey) {
        this.apiKey = apiKey;
    }
}
