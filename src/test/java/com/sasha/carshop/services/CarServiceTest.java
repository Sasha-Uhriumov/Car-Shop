package com.sasha.carshop.services;

import com.sasha.carshop.dto.ResponseCarDTO;
import com.sasha.carshop.dto.UpdateCarDTO;
import com.sasha.carshop.entity.Car;
import com.sasha.carshop.enums.DriveType;
import com.sasha.carshop.enums.TransmissionType;
import com.sasha.carshop.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    void updateCarById() {

        Long carId = 1L;

        Car existsCar = new Car();

        existsCar.setId(carId);
        existsCar.setModel("BMW");
        existsCar.setYearOfIssue(2000);
        existsCar.setMileage(20000);
        existsCar.setBodyType("sedan");
        existsCar.setColor("red");
        existsCar.setEngineSize(2.5);
        existsCar.setHorsePower(905);
        existsCar.setTransmissionType(TransmissionType.AUTOMATIC);
        existsCar.setDriveType(DriveType.AWD);
        existsCar.setVin("j3jre934r9msdm3ew");

        UpdateCarDTO updateCarDTO = new UpdateCarDTO();

        updateCarDTO.setModel("Audy");
        updateCarDTO.setYearOfIssue(2015);
        updateCarDTO.setMileage(13000);
        updateCarDTO.setBodyType("sedan");
        updateCarDTO.setColor("silver");
        updateCarDTO.setEngineSize(3.5);
        updateCarDTO.setHorsePower(1000);
        updateCarDTO.setTransmissionType(TransmissionType.MANUAL);
        updateCarDTO.setDriveType(DriveType.FWD);
        updateCarDTO.setVin("4fj49jfjekfj49frkj94");

        when(carRepository.findById(carId)).thenReturn(Optional.of(existsCar));

        ResponseCarDTO result = carService.updateCarById(carId, updateCarDTO);

        assertNotNull(result);
        assertEquals(carId, result.getId());
        assertEquals("Audy", result.getModel());
        assertEquals(2015, result.getYearOfIssue());
        assertEquals(13000, result.getMileage());
        assertEquals("sedan", result.getBodyType());
        assertEquals("silver", result.getColor());
        assertEquals(3.5, result.getEngineSize());
        assertEquals(1000, result.getHorsePower());
        assertEquals(TransmissionType.MANUAL, result.getTransmissionType());
        assertEquals(DriveType.FWD, result.getDriveType());
        assertEquals("4fj49jfjekfj49frkj94", result.getVin());
    }

    @Test
    void getCarById() {

        Long carId = 1L;

        Car existsCar = new Car();

        existsCar.setId(carId);
        existsCar.setModel("BMW");
        existsCar.setYearOfIssue(2000);
        existsCar.setMileage(20000);
        existsCar.setBodyType("sedan");
        existsCar.setColor("red");
        existsCar.setEngineSize(2.5);
        existsCar.setHorsePower(905);
        existsCar.setTransmissionType(TransmissionType.AUTOMATIC);
        existsCar.setDriveType(DriveType.AWD);
        existsCar.setVin("j3jre934r9msdm3ew");

        when(carRepository.findById(carId)).thenReturn(Optional.of(existsCar));

        ResponseCarDTO result = carService.getCarById(carId);

        assertNotNull(result);
        assertEquals(carId, result.getId());
        assertEquals("BMW", result.getModel());
        assertEquals(2000, result.getYearOfIssue());
        assertEquals(20000, result.getMileage());
        assertEquals("sedan", result.getBodyType());
        assertEquals("red", result.getColor());
        assertEquals(2.5, result.getEngineSize());
        assertEquals(905, result.getHorsePower());
        assertEquals(TransmissionType.AUTOMATIC, result.getTransmissionType());
        assertEquals(DriveType.AWD, result.getDriveType());
        assertEquals("j3jre934r9msdm3ew", result.getVin());
    }
}