package com.example.demo.service.bookingservice;

import com.example.demo.model.Booking;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

/**
 * Created by Nabeel on 1/2/2018.
 */
@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private UserRepository userRepository;

    private boolean alreadyBooked(final Booking pendingBooking) {
        final Set<Booking> allBookingsForVehiclesWithStatus = bookingRepository.findByVehicleAndStatusIn(pendingBooking.getVehicle(), Arrays.asList(Booking.Status.OPEN, Booking.Status.ACTIVE));
        for (final Booking booking : allBookingsForVehiclesWithStatus) {
            if (booking.getBegin().after(pendingBooking.getBegin()) && booking.getBegin().before(pendingBooking.getEnd())) {
                return true;
            }
        }
        return false;
    }

    private boolean isStatusUpdatePossible(final Booking booking, final Booking.Status status){
        if (!(status.equals(Booking.Status.ACTIVE) || status.equals(Booking.Status.CANCELLED))) {
            throw new IllegalArgumentException("A status transition is possible to " + Booking.Status.ACTIVE + " & " + Booking.Status.ACTIVE + " status only.");
        }
        return !status.equals(booking.getStatus());
    }

    @Transactional
    @Override
    public Booking updateBookingStatus(Long id, Booking.Status status) {
        final Booking booking = bookingRepository.findOne(id);
        if (isStatusUpdatePossible(booking, status)) {
            booking.setStatus(status);
            if (Booking.Status.CANCELLED.equals(status)) {
                deactivateVehicle(booking);
            }
            bookingRepository.saveAndFlush(booking);
        }

        return booking;
    }

    private void deactivateVehicle(final Booking booking) {
        final Vehicle vehicleToInactivate = vehicleRepository.findOne(booking.getVehicle().getId());
        vehicleToInactivate.setActive(false);
    }

    @Transactional
    @Override
    public Booking book(Booking booking) {
        setBookingConstraints(booking);
        if (!isBookable(booking)) {
            throw new IllegalArgumentException("User does not exist or vehicle cannot be booked.");
        }
        activateVehicle(booking);

        return bookingRepository.saveAndFlush(booking);
    }

    private void activateVehicle(final Booking booking) {
        final Vehicle vehicle = vehicleRepository.getOne(booking.getVehicle().getId());
        vehicle.setActive(true);
        vehicleRepository.saveAndFlush(vehicle);
    }

    private boolean isBookable(final Booking booking) {
        final Long bookingId = booking.getUser().getId();
        final Long vehicleId = booking.getVehicle().getId();
        if (userRepository.exists(bookingId) && vehicleRepository.exists(vehicleId)) {
            final Vehicle vehicle = vehicleRepository.findOne(vehicleId);

            return !vehicle.getActive() && !alreadyBooked(booking);
        }

        return false;
    }

    private void setBookingConstraints(final Booking booking) {
        final Date now = new Date();
        booking.setBegin(now);
        booking.setEnd(DateUtils.addHours(now, 24));
        booking.setStatus(Booking.Status.OPEN);

        final Vehicle vehicle = booking.getVehicle();
        vehicle.setActive(true);
    }

    @Override
    public List<Booking> findAll() { return bookingRepository.findAll(); }

    @Override
    public Booking findOne(Long id) { return bookingRepository.findOne(id); }
}
