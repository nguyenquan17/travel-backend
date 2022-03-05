package com.example.travel.services.impl;

import com.example.travel.dto.TourDetailDTO;
import com.example.travel.entity.*;
import com.example.travel.mapper.TourDetailMapper;
import com.example.travel.repository.ITourDetailRepository;
import com.example.travel.services.ITourDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class TourDetailService implements ITourDetailService {


    @Autowired
    private ITourDetailRepository iTourDetailRepository;

    public TourDetailMapper mapper = new TourDetailMapper();

    @Override
    public List<TourDetail> getAllTours() {
        return iTourDetailRepository.findAll();

    }

    @Override
    public List<TourDetail> getSearchAllToursByLocationAndDateAndPrice(String title, Date dayStart, Long price) {
        return iTourDetailRepository.getTourDetailByTitleOrDayStartOrPrice(title, dayStart, price);
    }

    @Override
    public TourDetail getTourDetailById(int id) {
        return iTourDetailRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void createTour(TourDetailDTO tourCreateForm) {
        TourDetail tourDetail = mapper.toEntity(tourCreateForm);
        iTourDetailRepository.save(tourDetail);
    }

    @Override
    @Transactional
    public void updateTour(int id, TourDetailDTO tourUpdateForm) {
        TourDetail tourDetail = getTourDetailById(id);
        if (tourDetail != null){
            tourDetail = mapper.toEntity(tourUpdateForm);
            iTourDetailRepository.save(tourDetail);
        }

    }

    @Override
    public void deleteTour(int id) {
        iTourDetailRepository.deleteById(id);
    }
}
