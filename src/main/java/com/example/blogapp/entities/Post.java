package com.example.blogapp.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 30,nullable = false)
    private String title;
////////testing
    @Column(length = 1000,nullable = false)
    private String content;
    private String imageLink;
    private Date addedDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

}
