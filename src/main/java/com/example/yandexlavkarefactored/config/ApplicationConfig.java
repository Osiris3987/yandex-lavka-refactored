package com.example.yandexlavkarefactored.config;

import com.example.yandexlavkarefactored.web.mappers.CourierMapper;
import com.example.yandexlavkarefactored.web.mappers.Impl.CourierMapperImpl;
import com.example.yandexlavkarefactored.web.mappers.Impl.OrderMapperImpl;
import com.example.yandexlavkarefactored.web.mappers.OrderMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CourierMapper courierMapper(){
        return new CourierMapperImpl();
    }

    @Bean
    public OrderMapper orderMapper(){
        return new OrderMapperImpl();
    }
}
