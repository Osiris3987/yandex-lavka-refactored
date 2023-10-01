package com.example.yandexlavkarefactored.service.Impl;

import com.example.yandexlavkarefactored.domain.courier.Courier;
import com.example.yandexlavkarefactored.domain.exception.ResourceNotFoundException;
import com.example.yandexlavkarefactored.domain.order.Order;
import com.example.yandexlavkarefactored.repository.CourierRepository;
import com.example.yandexlavkarefactored.repository.OrderRepository;
import com.example.yandexlavkarefactored.service.OrderService;
import com.example.yandexlavkarefactored.web.dto.order.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CourierRepository courierRepository;

    @Override
    public List<Order> create(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public List<Order> getAll(int offset, int limit) {
        return orderRepository.findAll(PageRequest.of(offset, limit)).getContent();
    }

    @Override
    public Order assignOrderToCourier(OrderDto.CompleteOrderDto completeOrderDto) {
        Courier courier = courierRepository.findById(completeOrderDto.courierId()).orElseThrow(
                () -> new ResourceNotFoundException("Courier not found")
        );
        Order order = orderRepository.findById(completeOrderDto.orderId()).orElseThrow(
                () -> new ResourceNotFoundException("Order not found")
        );
        courier.getOrders().add(order);
        order.setOrderCompleteTime(LocalDateTime.parse(completeOrderDto.completeTime()));
        courierRepository.save(courier);
        return order;
    }
}
