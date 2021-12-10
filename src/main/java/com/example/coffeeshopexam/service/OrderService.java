package com.example.coffeeshopexam.service;

import com.example.coffeeshopexam.model.service.OrderServiceModel;
import com.example.coffeeshopexam.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderByPriceDesc();

    void deleteOrderById(Long id);
}
