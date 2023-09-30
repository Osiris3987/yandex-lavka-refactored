package com.example.yandexlavkarefactored.web.mappers;

import com.example.yandexlavkarefactored.domain.courier.Courier;
import com.example.yandexlavkarefactored.web.dto.courier.CourierDto;

public interface CourierMapper {
    Courier toEntity(CourierDto courierDto);
    CourierDto toDto(Courier courierDto);
}
