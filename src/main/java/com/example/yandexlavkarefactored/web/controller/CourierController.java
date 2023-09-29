package com.example.yandexlavkarefactored.web.controller;


import com.example.yandexlavkarefactored.service.CourierService;
import com.example.yandexlavkarefactored.web.mappers.CourierMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/couriers")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService courierService;
    private final CourierMapper courierMapper;
}
