package com.example.travel.services.impl;

import com.example.travel.entity.Tour;
import com.example.travel.repository.ITourRepository;
import com.example.travel.services.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements ITourService {

    @Autowired
    ITourRepository tourRepository;

    @Override
    public Tour saveTour(Tour tour) {
        Tour newTour = new Tour();
        newTour.setName(tour.getName());
        newTour.setRegional(tour.getRegional());
        tourRepository.save(newTour);
        return newTour;
    }

    @Override
    public Tour editTour(Tour tour) {
        Tour editTour = new Tour();
        editTour.setName(tour.getName());
        editTour.setRegional(tour.getRegional());
        tourRepository.save(editTour);
        return editTour;
    }

    @Override
    public void deleteAccount(int id) {
        tourRepository.deleteById(id);
    }

}
