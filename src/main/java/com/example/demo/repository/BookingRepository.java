package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Nabeel on 1/2/2018.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Set<Booking> findByVehicleAndStatusIn(Vehicle vehicle, Collection<Booking.Status> status);
}
