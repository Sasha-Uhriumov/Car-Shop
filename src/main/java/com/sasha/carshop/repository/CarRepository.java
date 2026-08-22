package com.sasha.carshop.repository;

import com.sasha.carshop.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    boolean existsCarByVin(String vin);
}
