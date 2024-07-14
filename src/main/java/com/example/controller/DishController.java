package com.example.controller;

import com.example.domain.Dish;
import com.example.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dishes")
public class DishController { @Autowired
private DishRepository dishRepository;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Void> togglePublishStatus( @PathVariable Long dishId) {
        Optional<Dish> dishOptional = dishRepository.findById(dishId);
        if (dishOptional.isPresent()) {
            Dish dish = dishOptional.get();
            dish.setIsPublished(!dish.getIsPublished());
            dishRepository.save(dish);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

