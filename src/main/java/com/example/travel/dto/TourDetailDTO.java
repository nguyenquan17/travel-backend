package com.example.travel.dto;

import com.example.travel.entity.Regional;
import com.example.travel.entity.Tour;
import com.example.travel.entity.TourType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourDetailDTO {
    private int id;
    private String title;
    private String description;
    private String schedule;
    private Date dayStart;
    private String vehicle;
    private String departureFrom;
    private String price;
    private int quantity;
    private String notes;
    private String star;

    private UserDTO creator;
    private TourType tourType;
    private Regional regional;
    private Tour tour;
}
