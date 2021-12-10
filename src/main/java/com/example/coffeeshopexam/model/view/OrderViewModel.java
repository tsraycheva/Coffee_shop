package com.example.coffeeshopexam.model.view;

import com.example.coffeeshopexam.model.entity.Category;
import com.example.coffeeshopexam.model.entity.User;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;

    public Long getId() {
        return id;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public OrderViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }
}
