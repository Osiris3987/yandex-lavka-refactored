package com.example.yandexlavkarefactored.domain.courier;

import com.example.yandexlavkarefactored.domain.order.Order;
import com.example.yandexlavkarefactored.domain.period.Period;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "couriers")
@Data
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private CourierType courierType;
    @CollectionTable(name = "couriers_regions")
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "region")
    private List<Integer> region;

    @CollectionTable(name = "couriers_working_hours")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Period> workingHours;

    @CollectionTable(name = "couriers_orders")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders;
}
