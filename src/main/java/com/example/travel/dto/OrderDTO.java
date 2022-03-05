package com.example.travel.dto;

import com.example.travel.entity.Payment;
import com.example.travel.entity.PrimaryKey.TourOrderPK;
import com.example.travel.entity.TourDetail;
import com.example.travel.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class OrderDTO {
//    private TourOrderPK composeId;
    private int id;
    private String nameOrder;
    private Date dateOrder;
    private Long costOrder;
    private int numberOfPeople;
    private int numberOfRooms;
    private Payment paymentMethod;
    private TourDetailDTO tourDetail;
    private UserDTO customer;


}
