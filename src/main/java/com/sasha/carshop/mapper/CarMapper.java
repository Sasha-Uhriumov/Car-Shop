package com.sasha.carshop.mapper;

import com.sasha.carshop.dto.CreateCarDTO;
import com.sasha.carshop.dto.ResponseCarDTO;
import com.sasha.carshop.dto.UpdateCarDTO;
import com.sasha.carshop.entity.Car;

public class CarMapper {

    public static Car toEntity(CreateCarDTO dto) {
        Car car = new Car();

        car.setModel(dto.getModel());
        car.setYearOfIssue(dto.getYearOfIssue());
        car.setMileage(dto.getMileage());
        car.setBodyType(dto.getBodyType());
        car.setColor(dto.getColor());
        car.setEngineSize(dto.getEngineSize());
        car.setHorsePower(dto.getHorsePower());
        car.setTransmissionType(dto.getTransmissionType());
        car.setDriveType(dto.getDriveType());
        car.setVin(dto.getVin());
        return car;
    }

    public static ResponseCarDTO fromEntity(Car car) {
        ResponseCarDTO dto = new ResponseCarDTO();

        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setYearOfIssue(car.getYearOfIssue());
        dto.setMileage(car.getMileage());
        dto.setBodyType(car.getBodyType());
        dto.setColor(car.getColor());
        dto.setEngineSize(car.getEngineSize());
        dto.setHorsePower(car.getHorsePower());
        dto.setTransmissionType(car.getTransmissionType());
        dto.setDriveType(car.getDriveType());
        dto.setVin(car.getVin());

        return dto;
    }

    public static ResponseCarDTO updateCar(Car car, UpdateCarDTO dto) {

        car.setModel(dto.getModel());
        car.setYearOfIssue(dto.getYearOfIssue());
        car.setMileage(dto.getMileage());
        car.setBodyType(dto.getBodyType());
        car.setColor(dto.getColor());
        car.setEngineSize(dto.getEngineSize());
        car.setHorsePower(dto.getHorsePower());
        car.setTransmissionType(dto.getTransmissionType());
        car.setDriveType(dto.getDriveType());
        car.setVin(dto.getVin());

        return CarMapper.fromEntity(car);
    }
}
