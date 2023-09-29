package com.example.yandexlavkarefactored.web.mappers;

import com.example.yandexlavkarefactored.domain.order.Order;
import com.example.yandexlavkarefactored.web.dto.order.OrderDto;

public interface OrderMapper {
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
}
