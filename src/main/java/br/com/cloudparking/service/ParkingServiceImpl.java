package br.com.cloudparking.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import br.com.cloudparking.model.Parking;
@Service
public class ParkingServiceImpl implements ParkingServiceManual {

    private static final double ONE_HOUR_VALUE = 5.00;
    private static final double ADD_HOUR_VALUE = 2.00;
    private static final double DAILY_VALUE = 20.00;

    public void calculateCheckout(Parking parking) {
        LocalDateTime checkin = parking.getEntryDate();
        LocalDateTime checkout = parking.getExitDate();
        long hours = ChronoUnit.HOURS.between(checkin, checkout);
        double value;
        if(hours >= 24) {
            value = DAILY_VALUE;
            hours = hours % 24;
        } else {
            value = ONE_HOUR_VALUE;
            hours -= 1;
        }
        if(hours >= 1)
        value += ADD_HOUR_VALUE * hours;
        parking.setBill(value);
    }
    
}
