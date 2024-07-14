package com.example.controller;

import com.example.domain.Dish;
import com.example.repository.DishRepository;
import com.example.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dishes")
public class DishController {
    @Autowired
    private DishService dishService;

    //- Create an API to fetch the list of dishes from the database.
    @GetMapping
    public List<Dish> getAllDishes () {
        return dishService.getAllDishes();
    }

    //- Create an API to toggle the `isPublished` status of a dish.
    @PostMapping("/toggle/{id}")
    public Dish toggleDishStatus ( @PathVariable Long dishId ) {
        return dishService.toggleDishStatus(dishId);
    }

}

