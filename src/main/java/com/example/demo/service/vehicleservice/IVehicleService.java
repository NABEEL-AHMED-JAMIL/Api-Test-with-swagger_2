package com.example.demo.service.vehicleservice;

import com.example.demo.model.Vehicle;
import java.util.List;

/**
 * Created by Nabeel on 1/2/2018.
 */
public interface IVehicleService {

    public Vehicle registerVehicle(final Vehicle vehicle);
    public List<Vehicle> findAll();
    public Vehicle findOne(final Long id);
    public Vehicle findByLicensePlate(final String licensePlate);
}
