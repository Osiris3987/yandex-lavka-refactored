package com.example.yandexlavkarefactored.web.dto.order;

import com.example.yandexlavkarefactored.web.dto.validation.OnComplete;
import com.example.yandexlavkarefactored.web.dto.validation.OnCreate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
public class OrderDto {
    @NotNull(message = "Order id must be not null", groups = OnComplete.class)
    private Long id;
    @NotNull(message = "Order's cost must be not null", groups = {OnCreate.class})
    private Double cost;
    @NotNull(message = "Order's delivery region must be not null", groups = {OnCreate.class})
    private Integer region;
    @NotNull(message = "Order's weight must be not null", groups = {OnCreate.class})
    private Double weight;
    @NotNull(message = "Order's delivery hours must be not null", groups = {OnCreate.class})
    private List<String> deliveryInterval;

    public record CompleteOrderDto(
            @NotNull(message = "Courier not found", groups = {OnComplete.class})
            Long courierId,
            @NotNull(message = "Order not found", groups = OnComplete.class)
            Long orderId,
            @NotNull(message = "Complete time must not be null", groups = OnComplete.class)
            @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
            @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
            String completeTime
    ){}
}
