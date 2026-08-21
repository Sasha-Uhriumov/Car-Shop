package com.sasha.carshop.dto;

import com.sasha.carshop.enums.DriveType;
import com.sasha.carshop.enums.TransmissionType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCarDTO {

    private String model;
    private Integer yearOfIssue;
    private Integer mileage;
    private String bodyType;
    private String color;
    private Double engineSize;
    private Integer horsePower;
    private TransmissionType transmissionType;
    private DriveType driveType;
    private String vin;
}
