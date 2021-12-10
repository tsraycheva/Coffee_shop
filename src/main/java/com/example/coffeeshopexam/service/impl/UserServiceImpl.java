package com.example.coffeeshopexam.service.impl;

import com.example.coffeeshopexam.model.entity.User;
import com.example.coffeeshopexam.model.service.UserServiceModel;
import com.example.coffeeshopexam.model.view.UserViewModel;
import com.example.coffeeshopexam.repository.UserRepository;
import com.example.coffeeshopexam.service.UserService;
import com.example.coffeeshopexam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {


        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id).setUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc() {
        return userRepository.findAllByOrderByOrdersDesc()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername()).setCountOfOrders(user.getOrders().size());
                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
