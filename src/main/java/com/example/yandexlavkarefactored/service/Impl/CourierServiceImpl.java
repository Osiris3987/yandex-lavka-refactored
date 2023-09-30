package com.example.yandexlavkarefactored.service.Impl;

import com.example.yandexlavkarefactored.domain.courier.Courier;
import com.example.yandexlavkarefactored.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {
    @Override
    public void create(List<Courier> couriers) {

    }

    @Override
    public Courier get(Long id) {
        return null;
    }

    @Override
    public List<Courier> getAll(Long offset, Long Limit) {
        return null;
    }

}
