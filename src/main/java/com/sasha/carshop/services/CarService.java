package com.sasha.carshop.services;

import com.sasha.carshop.dto.CreateCarDTO;
import com.sasha.carshop.dto.ResponseCarDTO;
import com.sasha.carshop.entity.Car;
import com.sasha.carshop.mapper.CarMapper;
import com.sasha.carshop.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Transactional
    public ResponseCarDTO createCar(CreateCarDTO carDTO) {

       return CarMapper.fromEntity(carRepository.save(CarMapper.toEntity(carDTO)));
    }
}
