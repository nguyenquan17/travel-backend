package com.example.travel.repository;

import com.example.travel.entity.TourDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITourDetailRepository extends JpaRepository<TourDetail, Integer> {
}
