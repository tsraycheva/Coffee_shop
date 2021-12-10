package com.example.coffeeshopexam.model.view;

public class UserViewModel {
    private String username;
    private Integer countOfOrders;

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getCountOfOrders() {
        return countOfOrders;
    }

    public UserViewModel setCountOfOrders(Integer countOfOrders) {
        this.countOfOrders = countOfOrders;
        return this;
    }
}
