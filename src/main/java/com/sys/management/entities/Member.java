package com.sys.management.entities;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String username;

    @Column()
    private String password;

    @Column(unique = true)
    private String email;

    @Column()
    private String role;
}
