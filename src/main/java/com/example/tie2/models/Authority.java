package com.example.tie2.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@IdClass(AuthorityKey.class)
@Table(name = "authorities")

public class Authority implements Serializable {
    @Id
    @Column
    private String username;

    @Id
    @Column
    private String authority;

    public Authority() {
    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }
}
