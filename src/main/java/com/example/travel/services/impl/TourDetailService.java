package com.example.travel.services.impl;

import com.example.travel.entity.TourDetail;
import com.example.travel.repository.ITourDetailRepository;
import com.example.travel.services.ITourDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourDetailService implements ITourDetailService {

    @Autowired
    private ITourDetailRepository iTourDetailRepository;

    @Override
    public List<TourDetail> getAllTours() {
        return iTourDetailRepository.findAll();
    }
}
