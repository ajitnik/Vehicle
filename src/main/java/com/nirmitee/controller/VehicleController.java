package com.nirmitee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirmitee.model.Vehicle;
import com.nirmitee.service.VehicleService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@PostMapping("/cars")
	public ResponseEntity<?> createVehicle(@RequestBody Vehicle reqObj) {

		log.info("Inside createVehicle");
		return vehicleService.createVehicle(reqObj);

	}

	@GetMapping("/cars/{id}")
	public ResponseEntity<?> getVehicle(@PathVariable String id) {

		log.info("Inside getVehicle");
		return vehicleService.getVehicle(id);

	}

	@DeleteMapping("/cars/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable String id) {

		log.info("Inside deleteVehicle");
		return vehicleService.deleteVehicle(id);

	}

	@PutMapping("/cars/{id}")
	public ResponseEntity<?> updateVehicle(@RequestBody Vehicle reqObj, @PathVariable String id) {
		log.info("Inside updateVehicle");
		return vehicleService.updateVehicle(reqObj, id);
	}

}
