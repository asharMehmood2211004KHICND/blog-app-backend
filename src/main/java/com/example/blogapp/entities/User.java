package com.example.blogapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

//    @Column(name = "user_name",nullable = false,length = 100)

    @NotEmpty
    @Size(min = 3,message = "user name must be greater than or equal to 3 characters")
    private String name;

    @Email(message = "wmail address is not valid")
    private String email;
    @NotEmpty
    @Size(min = 4 , max = 20, message = "password should be in range of 4-20 chars")
    private String password;
    @NotEmpty
    private String about;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
}
