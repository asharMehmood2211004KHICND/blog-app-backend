package com.example.blogapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

////////okkok


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "user_name",nullable = false,length = 100)
    private String name;
    private String email;
    private String password;
    private String about;
}
