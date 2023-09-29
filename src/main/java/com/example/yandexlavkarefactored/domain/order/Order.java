package com.example.yandexlavkarefactored.domain.order;

import com.example.yandexlavkarefactored.domain.period.Period;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double cost;
    private Integer region;
    private Double weight;
    @JoinTable(name = "intervals")
    @CollectionTable(name = "orders_delivery_intervals")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Period> deliveryInterval;
    private LocalDateTime orderCompleteTime;

}
