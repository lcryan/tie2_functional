package com.example.tie2.dtos;

import com.example.tie2.models.Authority;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;
import java.util.Set;

public class UserDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private Boolean enabled;
    private String apikey;
    private String firstname;
    private String lastname;
    private String email;

    // -- connection with relation -- //

    public UserDto() {

    }

    @JsonSerialize
    public Set<Authority> authoritySet;

    // equals // comparing two objects for equality - comparing two instances of the class, that should be equal- & hashcode - used to calculate a hashcode - important if objects are stored as a hash table as in HashSet etc.  //

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Authority> getAuthoritySet() {
        return authoritySet;
    }

    public void setAuthoritySet(Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(enabled, userDto.enabled) && Objects.equals(apikey, userDto.apikey) && Objects.equals(firstname, userDto.firstname) && Objects.equals(lastname, userDto.lastname) && Objects.equals(email, userDto.email) && Objects.equals(authoritySet, userDto.authoritySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, enabled, apikey, firstname, lastname, email);
    }

}
