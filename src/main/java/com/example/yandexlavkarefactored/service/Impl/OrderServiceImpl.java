package com.example.yandexlavkarefactored.service.Impl;

import com.example.yandexlavkarefactored.domain.order.Order;
import com.example.yandexlavkarefactored.repository.OrderRepository;
import com.example.yandexlavkarefactored.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void create(Order order) {

    }

    @Override
    public Order get(Long id) {
        return null;
    }

    @Override
    public List<Order> getAll(Long offset, Long Limit) {
        return null;
    }

    @Override
    public void assignOrderToCourier(Long courierId, Long orderId, LocalDateTime completeTime) {

    }
}
