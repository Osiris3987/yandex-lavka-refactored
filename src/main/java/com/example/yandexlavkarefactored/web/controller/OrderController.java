package com.example.yandexlavkarefactored.web.controller;

import com.example.yandexlavkarefactored.domain.order.Order;
import com.example.yandexlavkarefactored.service.OrderService;
import com.example.yandexlavkarefactored.web.dto.order.OrderDto;
import com.example.yandexlavkarefactored.web.dto.validation.OnComplete;
import com.example.yandexlavkarefactored.web.dto.validation.OnCreate;
import com.example.yandexlavkarefactored.web.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public List<OrderDto> createOrders(@RequestBody @Validated(OnCreate.class) List<OrderDto> orderDtoList){
        List<Order> orders = orderMapper.toEntities(orderDtoList);
        return orderMapper.toDtos(orderService.create(orders));
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id){
        return orderMapper.toDto(orderService.getById(id));
    }

    @GetMapping
    public List<OrderDto> getAll(@RequestParam(required = false, defaultValue = "0") int offset,
                                 @RequestParam(required = false, defaultValue = "1") int limit){
        return orderMapper.toDtos(orderService.getAll(offset, limit));
    }

    @PostMapping("/complete")
    public OrderDto completeOrder(@RequestBody @Validated(OnComplete.class) OrderDto.CompleteOrderDto completeOrderDto){
        return orderMapper.toDto(orderService.assignOrderToCourier(completeOrderDto));
    }
}
