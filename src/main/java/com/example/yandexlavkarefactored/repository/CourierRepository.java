package com.example.yandexlavkarefactored.repository;

import com.example.yandexlavkarefactored.domain.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}
