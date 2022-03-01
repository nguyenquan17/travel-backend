package com.example.travel.repository;

import com.example.travel.entity.TourDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ITourDetailRepository extends JpaRepository<TourDetail, Integer> {
    List<TourDetail> getTourDetailByTitleContainingOrDayStartOrPriceLessThanEqual(String title, Date dayStart, Long price);
}
