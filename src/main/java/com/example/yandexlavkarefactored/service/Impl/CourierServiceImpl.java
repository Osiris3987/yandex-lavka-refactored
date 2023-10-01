package com.example.yandexlavkarefactored.service.Impl;

import com.example.yandexlavkarefactored.domain.courier.Courier;
import com.example.yandexlavkarefactored.domain.exception.ResourceNotFoundException;
import com.example.yandexlavkarefactored.repository.CourierRepository;
import com.example.yandexlavkarefactored.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;
    @Override
    @Transactional
    public List<Courier> create(List<Courier> couriers) {
        return courierRepository.saveAll(couriers);
    }

    @Override
    public Courier getById(Long id) {
        return courierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Courier not found"));
    }

    @Override
    public List<Courier> getAll(int offset, int limit) {
        return courierRepository.findAll(PageRequest.of(offset, limit)).getContent();
    }

}
