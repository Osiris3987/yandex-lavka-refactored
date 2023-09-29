package com.example.yandexlavkarefactored.domain.period;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Table(name = "intervals")
@Data
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "from_time")
    private LocalTime fromTime;
    @Column(name = "to_time")
    private LocalTime toTime;
}
