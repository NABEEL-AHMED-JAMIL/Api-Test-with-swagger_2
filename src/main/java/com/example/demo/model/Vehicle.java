package com.example.demo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;
/**
 * Created by Nabeel on 1/2/2018.
 */
@Entity
public class Vehicle extends AbstractPersistable {

    @NotEmpty(message = "Value may not be empty")
    @Column(unique = true)
    private String licensePlate;
    @NotEmpty(message = "Value may not be empty")
    private String vin;
    @NotEmpty(message = "Value may not be empty")
    private String model;
    @NotNull(message = "Value may not be null")
    private Boolean active;
    @NotEmpty(message = "Value may not be empty")
    private String color;
    @NotEmpty(message = "Value may not be empty")
    @Future(message = "Date should be in the future")
    private Date validTill;


    public Vehicle() {}
    public Vehicle(final Long id) { super.setId(id); }

    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Date getValidTill() { return validTill; }
    public void setValidTill(Date validTill) { this.validTill = validTill; }

    @Override
    public String toString() {
        return "Vehicle{" + "licensePlate='" + licensePlate + '\'' + ", vin='" + vin + '\'' + ", model='" + model + '\'' +
                ", active=" + active + ", color='" + color + '\'' + ", validTill=" + validTill + '}';
    }
}
