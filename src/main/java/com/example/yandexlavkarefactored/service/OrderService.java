package com.example.yandexlavkarefactored.service;

import com.example.yandexlavkarefactored.domain.order.Order;

import java.util.List;

public interface OrderService {
    void create(Order order);
    Order get(Long id);
    List<Order> getAll(Long offset, Long Limit);
}
