package com.example.yandexlavkarefactored.web.controller;

import com.example.yandexlavkarefactored.service.OrderService;
import com.example.yandexlavkarefactored.web.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

}
