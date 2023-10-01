package com.example.yandexlavkarefactored.web.mappers.Impl;

import com.example.yandexlavkarefactored.domain.order.Order;
import com.example.yandexlavkarefactored.utils.TimeParser;
import com.example.yandexlavkarefactored.web.dto.order.OrderDto;
import com.example.yandexlavkarefactored.web.mappers.OrderMapper;

import java.util.List;

public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order toEntity(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setCost(orderDto.getCost());
        order.setRegion(orderDto.getRegion());
        order.setWeight(orderDto.getWeight());
        order.setDeliveryInterval(TimeParser.parsePeriods(orderDto.getDeliveryInterval()));
        return order;
    }

    @Override
    public OrderDto toDto(Order order) {
        if (order == null) {
            return null;
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCost(order.getCost());
        orderDto.setWeight(order.getWeight());
        orderDto.setRegion(order.getRegion());
        orderDto.setDeliveryInterval(TimeParser.mapPeriodsToString(order.getDeliveryInterval()));
        return orderDto;
    }

    @Override
    public List<Order> toEntities(List<OrderDto> orderDtoList) {
        return orderDtoList.stream().map(this::toEntity).toList();
    }

    @Override
    public List<OrderDto> toDtos(List<Order> orderList) {
        return orderList.stream().map(this::toDto).toList();
    }
}
