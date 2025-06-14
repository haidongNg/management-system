package com.sys.management.entities;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column()
    private String name;
    @Column()
    private String description;
    @Column()
    private String category;
    @Column()
    private String price;
    @Column()
    private String image;
    @Column()
    private String status;
}
