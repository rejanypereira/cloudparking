package br.com.cloudparking.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParkingDTO {
    
    private Long id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Double bill;

    public Parking to() {
        Parking parking = new Parking();
        parking.setBill(bill);
        parking.setColor(color);
        parking.setEntryDate(entryDate);
        parking.setExitDate(exitDate);
        parking.setLicense(license);
        parking.setModel(model);
        parking.setState(state);
        return parking;
    }
}
