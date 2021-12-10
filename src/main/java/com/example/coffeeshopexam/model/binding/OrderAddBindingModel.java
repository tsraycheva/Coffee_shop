package com.example.coffeeshopexam.model.binding;

import com.example.coffeeshopexam.model.entity.Category;
import com.example.coffeeshopexam.model.entity.CategoryEnum;
import com.example.coffeeshopexam.model.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {

    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;
    @NotNull
    private CategoryEnum categoryEnum;
    @NotNull
    @Size(min = 5)
    private String description;

    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public OrderAddBindingModel setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
