package com.example.coffeeshopexam.model.service;

import com.example.coffeeshopexam.model.entity.CategoryEnum;
import com.example.coffeeshopexam.model.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private CategoryEnum categoryEnum;
    private String description;
    private User employee;

    public Long getId() {
        return id;
    }

    public OrderServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderServiceModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public OrderServiceModel setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
