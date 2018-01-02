package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Nabeel on 1/2/2018.
 */
@Entity
public class Booking extends AbstractPersistable {

    @NotNull(message = "Value may not be null")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private User user;
    @NotNull(message = "Value may not be null")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Vehicle vehicle;
    private Status status;
    @NotNull(message = "Value may not be null")
    private Date begin;
    @NotNull(message = "Value may not be null")
    private Date end;

    public enum Status { OPEN, ACTIVE, CANCELLED }

    public Booking() {}
    public Booking(final Long id) { super.setId(id); }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getBegin() {
        return begin;
    }
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }


    @Override
    public String toString() {
        return "Booking{" + "user=" + user + ", vehicle=" + vehicle +
                ", status=" + status + ", begin=" + begin + ", end=" + end + '}';
    }
}
