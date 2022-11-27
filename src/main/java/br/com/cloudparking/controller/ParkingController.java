package br.com.cloudparking.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cloudparking.controller.mapper.ParkingMapper;
import br.com.cloudparking.exception.ParkingNotFoundException;
import br.com.cloudparking.model.Parking;
import br.com.cloudparking.model.ParkingDTO;
import br.com.cloudparking.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    @Autowired private ParkingService service;
    @Autowired private ParkingMapper mapper;

    
    @ApiOperation("Find all Parkings")
    @GetMapping(path = {"", "/"})
    public List<ParkingDTO> findAll() {
        List<Parking> parkingList = service.findAll();
        return mapper.toParkingDTOList(parkingList);
    }

    @ApiOperation("Check-in Parking")
    @PostMapping(path = {"", "/"})
    public void checkin(@RequestBody ParkingDTO parkingDTO) {
        Parking parking = parkingDTO.to();
        service.save(parking);
    }

    @ApiOperation("Find Parking by ID")
    @GetMapping(path = "/{id}")
    public ParkingDTO findById(@PathVariable Long id) {
        Parking parking = service.findById(id).orElseThrow(() -> new ParkingNotFoundException("Parking not found!"));
        return mapper.toParkingDTO(parking);
    }

    @ApiOperation("Delete Parking by ID")
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        Parking parking = service.findById(id).orElseThrow(() -> new ParkingNotFoundException("Parking not found!"));
        service.delete(parking);
    }

    @ApiOperation("Update Parking")
    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestBody ParkingDTO dto) {
        Parking parking = service.findById(id).orElseThrow(() -> new ParkingNotFoundException("Parking not found!"));
        mapper.updateData(parking, dto);
        service.save(parking);
    }

    @ApiOperation("Checkout Parking")
    @PutMapping(path = "/{id}/checkout")
    public ParkingDTO checkout(@PathVariable Long id) {
        Parking parking = service.findById(id).orElseThrow(() -> new ParkingNotFoundException("Parking not found!"));
        parking.setExitDate(LocalDateTime.now());
        service.calculateCheckout(parking);
        service.save(parking);
        return mapper.toParkingDTO(parking);
    }

}
