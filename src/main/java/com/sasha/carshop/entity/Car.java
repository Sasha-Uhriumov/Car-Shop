package com.sasha.carshop.entity;

import com.sasha.carshop.enums.DriveType;
import com.sasha.carshop.enums.TransmissionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model", nullable = false, length = 30)
    private String model;

    @Column(name = "year_of_issue", nullable = false)
    private Integer yearOfIssue;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Column(name = "body_type", nullable = false, length = 20)
    private String bodyType;

    @Column(name = "color", nullable = false, length = 10)
    private String color;

    @Column(name = "engine_size", nullable = false)
    private Double engineSize;

    @Column(name = "horse_power", nullable = false)
    private Integer horsePower;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission_type", nullable = false, length = 10)
    private TransmissionType transmissionType;

    @Column(name = "driver_type", nullable = false, length = 5)
    private DriveType driveType;

    @Column(name = "vin", nullable = false, unique = true, length = 20)
    private String vin;
}
