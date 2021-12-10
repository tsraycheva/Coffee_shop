package com.example.coffeeshopexam.service;

import com.example.coffeeshopexam.model.entity.User;
import com.example.coffeeshopexam.model.service.UserServiceModel;
import com.example.coffeeshopexam.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
