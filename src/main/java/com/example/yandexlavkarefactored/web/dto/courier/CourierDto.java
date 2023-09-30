package com.example.yandexlavkarefactored.web.dto.courier;

import com.example.yandexlavkarefactored.domain.courier.CourierType;
import com.example.yandexlavkarefactored.web.dto.validation.OnComplete;
import com.example.yandexlavkarefactored.web.dto.validation.OnCreate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class CourierDto {
    @NotNull(message = "Courier id must be not null", groups = OnComplete.class)
    private Long id;
    @NotNull(message = "Courier type must be not null", groups = {OnCreate.class})
    private CourierType courierType;
    @NotNull(message = "Courier regions must be not null", groups = OnCreate.class)
    private List<Integer> regions;
    @NotNull(message = "Courier's working hours must not be null",groups = OnCreate.class)
    private List<String> workingHours;
}
