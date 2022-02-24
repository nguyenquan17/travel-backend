package com.example.travel.controller;

import com.example.travel.entity.Tour;
import com.example.travel.services.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    ITourService iTourService;

    @PostMapping("/tour")
    public ResponseEntity<?> createTour(@RequestBody Tour tour){
        iTourService.saveTour(tour);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/tour")
    public  ResponseEntity<?> editTour(@RequestBody Tour tour){
        iTourService.editTour(tour);
        return new ResponseEntity<String>("Edit success!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable(name = "id") int id) {
        iTourService.deleteAccount(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
