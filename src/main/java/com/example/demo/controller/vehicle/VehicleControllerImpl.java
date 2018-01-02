package com.example.demo.controller.vehicle;

import com.example.demo.model.Vehicle;
import com.example.demo.service.vehicleservice.IVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Nabeel on 1/2/2018.
 */
@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleControllerImpl implements IVehicleController {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleControllerImpl.class);

    @Autowired
    private IVehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> fetchAll() {
        LOG.debug("Fetching all vehicles");
        return vehicleService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Vehicle fetchById(@PathVariable("id") final Long id) {
        LOG.debug("Fetching vehicle");
        return vehicleService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle save(@RequestBody final Vehicle vehicle) {
        LOG.debug("Register vehicle");
        return vehicleService.registerVehicle(vehicle);
    }
}
