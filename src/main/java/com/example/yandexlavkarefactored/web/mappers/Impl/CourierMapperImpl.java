package com.example.yandexlavkarefactored.web.mappers.Impl;

import com.example.yandexlavkarefactored.domain.courier.Courier;
import com.example.yandexlavkarefactored.utils.TimeParser;
import com.example.yandexlavkarefactored.web.dto.courier.CourierDto;
import com.example.yandexlavkarefactored.web.mappers.CourierMapper;

public class CourierMapperImpl implements CourierMapper {
    @Override
    public Courier toEntity(CourierDto courierDto) {
        if(courierDto == null){
            return null;
        }
        Courier courier = new Courier();
        courier.setId(courierDto.getId());
        courier.setCourierType(courierDto.getCourierType());
        courier.setRegion(courierDto.getRegions());
        courier.setWorkingHours(TimeParser.parsePeriods(courierDto.getWorkingHours()));
        return courier;
    }

    @Override
    public CourierDto toDto(Courier courier) {
        if(courier == null){
            return null;
        }
        CourierDto courierDto = new CourierDto();
        courierDto.setId(courier.getId());
        courierDto.setCourierType(courier.getCourierType());
        courierDto.setRegions(courier.getRegion());
        courierDto.setWorkingHours(TimeParser.mapPeriodsToString(courier.getWorkingHours()));
        return courierDto;
    }
}
