package com.nirmitee.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nirmitee.model.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String>{

	Optional<Vehicle> findByVehicleId(String id);

	@Transactional
	Optional<Long> deleteByVehicleId(String id);

}
