package com.example.service;

import com.example.domain.Dish;
import com.example.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish toggleDishStatus(Long id) {
        Dish dish = dishRepository.findById(id).orElseThrow();
        dish.setIsPublished(!dish.getIsPublished());
        return dishRepository.save(dish);
    }

    public Dish togglePublishStatus(Long dishId) {
        Dish dish = dishRepository.findById(dishId)
                                  .orElseThrow(() -> new RuntimeException("Dish not found with id: " + dishId));

        dish.setIsPublished(!dish.getIsPublished());
        return dishRepository.save(dish);
    }


}
