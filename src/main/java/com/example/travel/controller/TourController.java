package com.example.travel.controller;

import com.example.travel.dto.TourDetailDTO;
import com.example.travel.dto.UserDTO;
import com.example.travel.entity.Regional;
import com.example.travel.entity.Tour;
import com.example.travel.entity.TourDetail;
import com.example.travel.entity.TourType;
import com.example.travel.services.ITourDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/tours")
@CrossOrigin("*")
public class TourController {

    @Autowired
    private ITourDetailService iTourDetailService;

    @GetMapping
    public ResponseEntity<List<TourDetailDTO>> getAllTours(){
        List<TourDetail> tourDetailEntity = iTourDetailService.getAllTours();
        List<TourDetailDTO> tourDetailDTOList = new ArrayList<>();
        for (TourDetail entity: tourDetailEntity ) {
            tourDetailDTOList.add(
                    new TourDetailDTO(
                            entity.getId(),
                            entity.getTitle(),
                            entity.getDescription(),
                            entity.getSchedule(),
                            entity.getDayStart(),
                            entity.getVehicle(),
                            entity.getDepartureFrom(),
                            entity.getPrice(),
                            entity.getQuantity(),
                            entity.getNotes(),
                            entity.getStar(),
                            new UserDTO(entity.getManager().getId()),
                            new TourType(entity.getTourType().getId()),
                            new Regional(entity.getRegional().getId()),
                            new Tour(entity.getTourName().getId())
                    )
            );
        }

        return new ResponseEntity<>(tourDetailDTOList, HttpStatus.OK) {
        };
    }
}
