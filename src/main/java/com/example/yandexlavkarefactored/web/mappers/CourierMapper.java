package com.example.yandexlavkarefactored.web.mappers;

import com.example.yandexlavkarefactored.domain.courier.Courier;
import com.example.yandexlavkarefactored.web.dto.courier.CourierDto;

import java.util.List;

public interface CourierMapper {
    Courier toEntity(CourierDto courierDto);
    CourierDto toDto(Courier courierDto);

    List<CourierDto> toDtos(List<Courier> couriers);

    List<Courier> toEntities(List<CourierDto> courierDtoList);
}
