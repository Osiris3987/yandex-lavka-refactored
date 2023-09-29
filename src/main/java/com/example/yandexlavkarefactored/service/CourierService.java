package com.example.yandexlavkarefactored.service;

import com.example.yandexlavkarefactored.domain.courier.Courier;

import java.time.LocalDateTime;
import java.util.List;

public interface CourierService {
    void create(List<Courier> couriers);
    Courier get(Long id);
    List<Courier> getAll(Long offset, Long Limit);
    void assignOrderToCourier(Long courierId, Long orderId, LocalDateTime completeTime);
}
