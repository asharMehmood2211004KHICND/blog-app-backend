package com.example.blogapp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @NotBlank
    @Size(min=4)
    @Column(name="title")
    private String categoryTitle;

    @Size(max = 20)
    @Column(name="description")
    private String categoryDescription;

    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();


}
