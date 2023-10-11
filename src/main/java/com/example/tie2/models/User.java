package com.example.tie2.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column
    private String apikey;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

    public User() {
    }

    public User(String username, String password, boolean enabled, String apikey, String firstname, String lastname, String email, Set<Authority> authoritySet) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.apikey = apikey;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.authoritySet = authoritySet;
    }

    //---  set up relation to Authority --- //
    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)

    // methods to add and remove auth from user //
    private Set<Authority> authoritySet = new HashSet<>();

    public Set<Authority> getAuthoritySet() {
        return authoritySet;
    }

    public void addAuthority(Authority authority) {
        this.authoritySet.add(authority); // adding auth. to the list of auths //
    }

    public void removeAuthority(Authority authority) {
        this.authoritySet.remove(authority); // removal of authority from authority list //
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
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
}
