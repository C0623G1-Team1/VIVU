package com.tourbooking.service.booking.impl;
import com.tourbooking.model.booking.Promotion;
import com.tourbooking.repository.booking.IPromotionRepository;
import com.tourbooking.service.booking.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    IPromotionRepository repository;

    @Override
    public Promotion findByCode(String code) {
        return repository.findByPromotionCode(code);
    }
}
