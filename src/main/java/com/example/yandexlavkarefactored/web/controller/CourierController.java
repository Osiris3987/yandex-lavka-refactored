package com.example.yandexlavkarefactored.web.controller;


import com.example.yandexlavkarefactored.domain.courier.Courier;
import com.example.yandexlavkarefactored.service.CourierService;
import com.example.yandexlavkarefactored.web.dto.courier.CourierDto;
import com.example.yandexlavkarefactored.web.dto.validation.OnCreate;
import com.example.yandexlavkarefactored.web.mappers.CourierMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/couriers")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService courierService;
    private final CourierMapper courierMapper;

    @PostMapping
    public List<CourierDto> createCouriers(@RequestBody @Validated(OnCreate.class) List<CourierDto> courierDto) {
        List<Courier> couriers = courierMapper.toEntities(courierDto);
        return courierMapper.toDtos(courierService.create(couriers));
    }

    @GetMapping("/{id}")
    public CourierDto getById(@PathVariable Long id) {
        return courierMapper.toDto(courierService.getById(id));
    }

    @GetMapping
    public List<CourierDto> getAll(@RequestParam(required = false, defaultValue = "0") int offset,
                                   @RequestParam(required = false, defaultValue = "1") int limit) {
        return courierMapper.toDtos(courierService.getAll(offset, limit));
    }
}
