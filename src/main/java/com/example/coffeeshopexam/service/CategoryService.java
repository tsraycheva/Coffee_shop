package com.example.coffeeshopexam.service;

import com.example.coffeeshopexam.model.entity.Category;
import com.example.coffeeshopexam.model.entity.CategoryEnum;

public interface CategoryService {


    void initCategories();

    Category findByCategoryNameEnum(CategoryEnum categoryEnum);
}
