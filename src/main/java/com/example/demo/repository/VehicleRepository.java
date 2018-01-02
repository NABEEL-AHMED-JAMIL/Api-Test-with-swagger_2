package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by Nabeel on 1/2/2018.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByLicensePlate(String licensePlate);
}
