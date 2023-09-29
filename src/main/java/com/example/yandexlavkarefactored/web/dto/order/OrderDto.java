package com.example.yandexlavkarefactored.web.dto.order;

import com.example.yandexlavkarefactored.web.dto.validation.OnComplete;
import com.example.yandexlavkarefactored.web.dto.validation.OnCreate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
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
    private List<String> deliveryHours;
    @NotNull(message = "Order's complete time must be not null", groups = {OnComplete.class})
    private LocalDateTime completeTime;
}
