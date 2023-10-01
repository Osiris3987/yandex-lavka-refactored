package com.example.yandexlavkarefactored.service;

import com.example.yandexlavkarefactored.domain.order.Order;
import com.example.yandexlavkarefactored.web.dto.order.OrderDto;


import java.util.List;

public interface OrderService {
    List<Order> create(List<Order> orders);
    Order getById(Long id);
    List<Order> getAll(int offset, int limit);
    Order assignOrderToCourier(OrderDto.CompleteOrderDto completeOrderDto);
}
