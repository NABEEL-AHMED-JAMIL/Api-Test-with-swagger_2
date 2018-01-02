package com.example.demo.service.bookingservice;

import com.example.demo.model.Booking;
import java.util.List;
/**
 * Created by Nabeel on 1/2/2018.
 */
public interface IBookingService {

    public Booking updateBookingStatus(final Long id, final Booking.Status status);
    public Booking book(final Booking booking);
    public List<Booking> findAll();
    public Booking findOne(final Long id);

}
