package com.example.travel.services;

import com.example.travel.dto.TourDetailDTO;
import com.example.travel.entity.TourDetail;
import com.example.travel.form.TourCreateForm;
import com.example.travel.form.TourUpdateForm;

import java.util.Date;
import java.util.List;

public interface ITourDetailService {
    List<TourDetail> getAllTours();
    List<TourDetail> getSearchAllToursByLocationAndDateAndPrice(String title, Date dayStart, Long price);
    TourDetail getTourDetailById(int id);
    void createTour(TourDetailDTO tourCreateForm);
    void updateTour(int id, TourDetailDTO tourUpdateForm);
    void deleteTour(int id);
    void deleteTours(List<Integer> ids);
}
