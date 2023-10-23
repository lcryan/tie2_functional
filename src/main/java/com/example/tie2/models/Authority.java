package com.example.tie2.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor

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
}
