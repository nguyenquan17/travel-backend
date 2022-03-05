package com.example.travel.controller;

import com.example.travel.dto.TourDetailDTO;
import com.example.travel.dto.UserDTO;
import com.example.travel.entity.*;
import com.example.travel.mapper.TourDetailMapper;
import com.example.travel.services.ITourDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/tours")
@CrossOrigin("*")
@ControllerAdvice
public class TourController {

    @Autowired
    private ITourDetailService iTourDetailService;

    TourDetailMapper mapper = new TourDetailMapper();

    @GetMapping
    public ResponseEntity<List<TourDetailDTO>> getAllTours(){
        List<TourDetail> tourDetailEntity = iTourDetailService.getAllTours();
        List<TourDetailDTO> tourDetailDTOList = new ArrayList<>();
        for (TourDetail entity: tourDetailEntity ) {
            tourDetailDTOList.add(
                    mapper.toDto(entity)
            );
        }

        return new ResponseEntity<>(tourDetailDTOList, HttpStatus.OK) {
        };
    }

    @GetMapping("/search")
    public ResponseEntity<List<TourDetailDTO>> getSearchAllTours(@RequestParam(required = false) String location,
                                                                 @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy.MM.dd") Date date,
                                                                 @RequestParam(required = false) Long price) {
        List<TourDetail> tourDetailEntity = iTourDetailService.getSearchAllToursByLocationAndDateAndPrice(location,date,price);
        List<TourDetailDTO> tourDetailDTOList = new ArrayList<>();
        for (TourDetail entity: tourDetailEntity){
            tourDetailDTOList.add(
                    mapper.toDto(entity)
            );
        }
        return new ResponseEntity<>(tourDetailDTOList, HttpStatus.OK);
    }

    @PostMapping("/create-tour")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('Manager')")
    public ResponseEntity<?> createTour(@RequestBody TourDetailDTO tourCreateForm){
        iTourDetailService.createTour(tourCreateForm);
        return new ResponseEntity<String>("Created !", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('Admin')")
//    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<?> updateTour(@PathVariable(name = "id") int id, @RequestBody TourDetailDTO tourUpdateForm){
        iTourDetailService.updateTour(id, tourUpdateForm);
        return new ResponseEntity<String>("Updated !", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('Admin')")
//    @Secured("User")
    public ResponseEntity<?> deleteTour(@PathVariable(name = "id") int id){
        iTourDetailService.deleteTour(id);
        return new ResponseEntity<String>("Deleted !", HttpStatus.OK);
    }

    ////////////////////////////////////////////////////////////////

}
