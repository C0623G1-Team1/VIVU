package com.tourbooking.service.booking;


import com.tourbooking.model.booking.Promotion;

public interface IPromotionService {
    Promotion findByCode(String code);

}
