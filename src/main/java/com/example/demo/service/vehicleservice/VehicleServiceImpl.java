package com.example.demo.service.vehicleservice;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nabeel on 1/2/2018.
 */
@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle registerVehicle(final Vehicle vehicle) { return vehicleRepository.saveAndFlush(vehicle); }

    @Override
    public List<Vehicle> findAll() { return vehicleRepository.findAll(); }

    @Override
    public Vehicle findOne(final Long id) { return vehicleRepository.findOne(id); }

    @Override
    public Vehicle findByLicensePlate(final String licensePlate) { return vehicleRepository.findByLicensePlate(licensePlate); }

}
