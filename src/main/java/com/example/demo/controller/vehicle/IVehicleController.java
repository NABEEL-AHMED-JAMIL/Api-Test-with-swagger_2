package com.example.demo.controller.vehicle;

import com.example.demo.model.Vehicle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Nabeel on 1/2/2018.
 */
public interface IVehicleController {

    public List<Vehicle> fetchAll();
    public Vehicle fetchById(@PathVariable("id") final Long id);
    public Vehicle save(@RequestBody final Vehicle vehicle);

}
