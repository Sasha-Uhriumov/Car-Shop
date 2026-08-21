package com.sasha.carshop.controller;

import com.sasha.carshop.dto.CreateCarDTO;
import com.sasha.carshop.dto.ResponseCarDTO;
import com.sasha.carshop.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<ResponseCarDTO> createCar(@RequestBody CreateCarDTO carDTO) {

        return ResponseEntity.ok(carService.createCar(carDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseCarDTO>> cars() {

        return ResponseEntity.ok(carService.getAllCars());
    }
}
