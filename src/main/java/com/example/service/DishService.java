package com.example.service;

import com.example.domain.Dish;
import com.example.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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


    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void togglePublishStatus(Long dishId) {
        Optional<Dish> dishOptional = dishRepository.findById(dishId);
        if (dishOptional.isPresent()) {
            Dish dish = dishOptional.get();
            dish.setIsPublished(!dish.getIsPublished());
            dishRepository.save(dish);
            messagingTemplate.convertAndSend("/topic/dish-updates", dish);
        }
    }


}
