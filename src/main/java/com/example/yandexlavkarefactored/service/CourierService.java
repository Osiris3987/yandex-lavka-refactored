package com.example.yandexlavkarefactored.service;

import com.example.yandexlavkarefactored.domain.courier.Courier;

import java.util.List;

public interface CourierService {
    List<Courier> create(List<Courier> couriers);
    Courier getById(Long id);
    List<Courier> getAll(int offset, int Limit);
}
