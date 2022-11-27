package br.com.cloudparking.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.cloudparking.model.Parking;
import br.com.cloudparking.model.ParkingDTO;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();
    
    public Parking toParking(ParkingDTO dto) {
        return MODEL_MAPPER.map(dto, Parking.class);
    }

    public ParkingDTO toParkingDTO(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }

    public void updateData(Parking parking, ParkingDTO dto) {
        parking.setBill(dto.getBill());
        parking.setColor(dto.getColor());
        parking.setEntryDate(dto.getEntryDate());
        parking.setExitDate(dto.getExitDate());
        parking.setLicense(dto.getLicense());
        parking.setModel(dto.getModel());
        parking.setState(dto.getState());
    }

}
