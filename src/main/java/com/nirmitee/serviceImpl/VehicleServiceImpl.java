package com.nirmitee.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nirmitee.dto.APIResponse;
import com.nirmitee.exception.DataNotStoredException;
import com.nirmitee.exception.InvalidInputException;
import com.nirmitee.exception.ResourceNotFoundException;
import com.nirmitee.model.Vehicle;
import com.nirmitee.repository.VehicleRepository;
import com.nirmitee.service.VehicleService;
import com.nirmitee.utility.AppConstants;
import com.nirmitee.utility.SequenceGeneratorService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository repo;

	@Autowired
	SequenceGeneratorService sequenceGenerator;

	@Override
	public ResponseEntity<?> createVehicle(Vehicle reqObj) {
		log.info("Inside createVehicle() {}", reqObj);

		if (reqObj == null)
			throw new InvalidInputException("Invalid Vehicle Input Data");

		reqObj.setCreatedDate(LocalDateTime.now());
		reqObj.setUpdatedDate(LocalDateTime.now());
		reqObj.setVehicleId(getVehicleId());

		Vehicle savedResponse = repo.save(reqObj);

		if (savedResponse == null)
			throw new DataNotStoredException("Vehicle Not saved");

		APIResponse response = new APIResponse();
		response.setResponseData(savedResponse.getVehicleId());
		response.setResult(AppConstants.SUCCESS);
		response.setResponseMessage("Vehicle saved");

		return new ResponseEntity<APIResponse>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getVehicle(String id) {
		log.info("Inside getVehicle() {}", id);

		if (id == null || "".equals(id))
			throw new InvalidInputException("Invalid Vehicle Input Data");

		Optional<Vehicle> deletedResponse = repo.findByVehicleId(id);

		if (!deletedResponse.isPresent())
			throw new ResourceNotFoundException("Vehicle Details Not found");

		APIResponse response = new APIResponse();
		response.setResponseData(deletedResponse.get());
		response.setResult(AppConstants.SUCCESS);
		response.setResponseMessage("Vehicle Details Found");

		return new ResponseEntity<APIResponse>(response, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<?> deleteVehicle(String id) {
		log.info("Inside deleteVehicle() {}", id);

		if (id == null || "".equals(id))
			throw new InvalidInputException("Invalid Vehicle Input Data");

		Optional<Long> deletedResponse = repo.deleteByVehicleId(id);

		if (!deletedResponse.isPresent())
			throw new ResourceNotFoundException("Vehicle Details Not deleted");

		APIResponse response = new APIResponse();
		response.setResponseData(deletedResponse.get());
		response.setResult(AppConstants.SUCCESS);
		response.setResponseMessage("Vehicle Details Deleted");

		return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateVehicle(Vehicle reqObj, String id) {
		log.info("Inside getVehicle() {}", id);

		if (id == null || "".equals(id) || reqObj == null)
			throw new InvalidInputException("Invalid Vehicle Input Data");

		Optional<Vehicle> savedResponse = repo.findByVehicleId(id);

		if (!savedResponse.isPresent())
			throw new ResourceNotFoundException("Vehicle Details Not found");

		Vehicle vehicle = savedResponse.get();

		updateVehicleDetails(vehicle, reqObj);

		APIResponse response = new APIResponse();
		response.setResponseData(id);
		response.setResult(AppConstants.SUCCESS);
		response.setResponseMessage("Vehicle Details Updated");

		return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
	}

	private void updateVehicleDetails(Vehicle vehicle, Vehicle reqObj) {

		vehicle.setCondition(reqObj.getCondition());
		vehicle.setDetails(reqObj.getDetails());
		vehicle.setLocation(reqObj.getLocation());
		vehicle.setUpdatedDate(LocalDateTime.now());
	}

	public String getVehicleId() {
		String vehicleId = null;
		Long nextId = sequenceGenerator.generateSequence(AppConstants.VEHICLE_SEQUENCE_NAME);

		if (nextId != null) {
			vehicleId = "VEH" + nextId.toString();
		}
		log.info("Created Vehicle Id {} ", vehicleId);

		return vehicleId;

	}
}
