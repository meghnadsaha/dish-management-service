package com.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dishId;
    private String dishName;
    private String imageUrl;
    private Boolean isPublished;

    // Getters and Setters
}
