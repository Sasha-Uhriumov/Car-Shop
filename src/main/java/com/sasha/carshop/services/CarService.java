package com.sasha.carshop.services;

import com.sasha.carshop.dto.CreateCarDTO;
import com.sasha.carshop.dto.ResponseCarDTO;
import com.sasha.carshop.dto.UpdateCarDTO;
import com.sasha.carshop.entity.Car;
import com.sasha.carshop.mapper.CarMapper;
import com.sasha.carshop.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Transactional
    public ResponseCarDTO createCar(CreateCarDTO carDTO) {

        if (carRepository.existsCarByVin(carDTO.getVin())) {
            throw new IllegalArgumentException();
        }

        Car car = CarMapper.toEntity(carDTO);
        return CarMapper.fromEntity(carRepository.save(car));
    }

    @Transactional(readOnly = true)
    public ResponseCarDTO getCarById(Long id) {

        return CarMapper.fromEntity(carRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<ResponseCarDTO> getAllCars() {

        return carRepository.findAll().stream()
                .map(CarMapper::fromEntity)
                .toList();

    }

    @Transactional
    public ResponseCarDTO updateCarById(Long id, UpdateCarDTO updateCarDTO) {

        Car existsCar = carRepository.findById(id).orElseThrow();

        return CarMapper.updateCar(existsCar, updateCarDTO);
    }
}
