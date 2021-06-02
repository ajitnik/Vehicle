package com.nirmitee.model;

import lombok.Data;

@Data
public class VehicleDetails {

	private String body;
	private String model;
	private ManufacturerDetails manufacturer;
	private Integer numberOfDoors;
	private String fuelType;
	private String engine;
	private Double mileage;
	private Integer modelYear;
	private Integer productionYear;
	private String externalColor;

}
