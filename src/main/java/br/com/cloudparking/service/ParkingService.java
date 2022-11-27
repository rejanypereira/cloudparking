package br.com.cloudparking.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.cloudparking.model.Parking;

@Service
public interface ParkingService extends JpaRepository<Parking, Long>, ParkingServiceManual {

}
