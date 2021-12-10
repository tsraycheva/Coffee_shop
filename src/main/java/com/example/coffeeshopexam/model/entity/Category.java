package com.example.coffeeshopexam.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum name;
    @Column(nullable = false)
    private Integer neededTime;

    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
