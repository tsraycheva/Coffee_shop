package com.example.coffeeshopexam.service.impl;

import com.example.coffeeshopexam.model.entity.Category;
import com.example.coffeeshopexam.model.entity.CategoryEnum;
import com.example.coffeeshopexam.repository.CategoryRepository;
import com.example.coffeeshopexam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategories() {
        if (categoryRepository.count()==0) {

            Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
                Category category = new Category();
                category.setName(categoryEnum);
                switch (category.getName()) {
                    case CAKE: category.setNeededTime(10);
                        break;
                    case DRINK: category.setNeededTime(1);
                        break;
                    case COFFEE: category.setNeededTime(2);
                        break;
                    case OTHER: category.setNeededTime(5);
                        break;
                }
                categoryRepository.save(category);
            });

        }

    }

    @Override
    public Category findByCategoryNameEnum(CategoryEnum categoryEnum) {
        return categoryRepository.findByName(categoryEnum).orElse(null);
    }
}
