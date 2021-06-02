package com.nirmitee.service;

import org.springframework.http.ResponseEntity;

import com.nirmitee.model.Vehicle;

public interface VehicleService {

	ResponseEntity<?> createVehicle(Vehicle reqObj);

	ResponseEntity<?> getVehicle(String id);

	ResponseEntity<?> deleteVehicle(String id);

	ResponseEntity<?> updateVehicle(Vehicle reqObj, String id);

}
