package com.sasha.carshop.controller;

import com.sasha.carshop.dto.CreateCarDTO;
import com.sasha.carshop.dto.ResponseCarDTO;
import com.sasha.carshop.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @PostMapping()
    public ResponseEntity<ResponseCarDTO> createCar(@RequestBody CreateCarDTO carDTO) {

        return ResponseEntity.ok(carService.createCar(carDTO));
    }
}
