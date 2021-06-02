package com.nirmitee.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "vehicle")
public class Vehicle {

	@Id
	private String _id;
	private String vehicleId;
	private String condition;
	private VehicleDetails details;
	private Location location;

	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}
