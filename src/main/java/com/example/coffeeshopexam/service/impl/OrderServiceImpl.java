package com.example.coffeeshopexam.service.impl;

import com.example.coffeeshopexam.model.entity.Order;
import com.example.coffeeshopexam.model.service.OrderServiceModel;
import com.example.coffeeshopexam.model.view.OrderViewModel;
import com.example.coffeeshopexam.repository.OrderRepository;
import com.example.coffeeshopexam.service.CategoryService;
import com.example.coffeeshopexam.service.OrderService;
import com.example.coffeeshopexam.service.UserService;
import com.example.coffeeshopexam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);

        order.setEmployee(userService.findById(currentUser.getId()))
                .setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategoryEnum()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrdersOrderByPriceDesc() {
        return orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
