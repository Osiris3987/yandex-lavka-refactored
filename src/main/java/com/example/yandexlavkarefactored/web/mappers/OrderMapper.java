package com.example.yandexlavkarefactored.web.mappers;

import com.example.yandexlavkarefactored.domain.order.Order;
import com.example.yandexlavkarefactored.web.dto.order.OrderDto;

import java.util.List;

public interface OrderMapper {
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
    List<Order> toEntities(List<OrderDto> orderDtoList);
    List<OrderDto> toDtos(List<Order> orderList);
}
