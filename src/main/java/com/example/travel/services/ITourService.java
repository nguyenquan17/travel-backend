package com.example.travel.services;

import com.example.travel.entity.Tour;
import org.springframework.stereotype.Service;


public interface ITourService {
    Tour saveTour(Tour tour);

    Tour editTour(Tour tour);

    void deleteAccount(int id);
}
